package br.com.b2w.bit.starwars.api.v1.integration;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class StarWarsIntegrationImpl implements StarWarsIntegration {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	private static final String USER_AGENT = "user-agent";
	private static final String USER_AGENT_VALUE = "B2W.bit";
	private static final String URL_API = "https://swapi.co/api/planets/?search={nome}";

	@Override
	public Long bucaQuantidadeDeFilmes(String nome) {
		Long quantidadeFilmes = 0L;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(USER_AGENT, USER_AGENT_VALUE);
			headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			
			ResponseEntity<PlanetaIntegratioResponse> planetaResponse = new RestTemplate()
					.exchange(URL_API, HttpMethod.GET, entity, PlanetaIntegratioResponse.class, nome);
			
			PlanetaIntegratioResponse planetaIntegration = planetaResponse.getBody();
			
			if(planetaIntegration.getCount() == 1) {
				quantidadeFilmes = planetaIntegration
						.getResults().stream()
						.filter(planeta -> planeta.getName().equalsIgnoreCase(nome))
						.mapToLong(planetaWS -> planetaWS.getFilms().stream().count()).sum();
			}
		} catch (RestClientException e) {
			logger.error("Não foi possível obter a quantidade de filmes");
		} 
		
		return quantidadeFilmes;
	}

}

package br.com.b2w.bit.starwars.api.v1.integration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
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
import org.apache.logging.log4j.util.Strings;

@Component
public class StarWarsIntegrationImpl implements StarWarsIntegration {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${sw.user.agent}")
	private String userAgent;
	
	@Value("${sw.url.api.busca.nome}")
	private String urlApi;

	@Override
	public Long bucaQuantidadeDeFilmes(String nome) {
		Long quantidadeFilmes = 0L;
		
		try {
			if(Strings.isBlank(nome)) {
				return quantidadeFilmes;
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("user-agent", userAgent);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			
			ResponseEntity<PlanetaIntegratioResponse> planetaResponse = new RestTemplate()
					.exchange(urlApi, HttpMethod.GET, entity, PlanetaIntegratioResponse.class, nome);
			
			PlanetaIntegratioResponse planetaIntegration = planetaResponse.getBody();
			
			if(planetaIntegration.getCount() == 1) {
				quantidadeFilmes = planetaIntegration
						.getResults().stream()
						.filter(planeta -> nome.equalsIgnoreCase(planeta.getName()))
						.mapToLong(planetaWS -> planetaWS.getFilms().stream().count())
						.sum();
			}
		} catch (RestClientException e) {
			logger.error("Não foi possível obter a quantidade de filmes");
		} 
		
		return quantidadeFilmes;
	}

}

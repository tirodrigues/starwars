package br.com.b2w.bit.starwars.api.v1.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.b2w.bit.starwars.api.v1.commands.PlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.controllers.PlanetaController;
import br.com.b2w.bit.starwars.api.v1.models.Planeta;

@Component
public class PlanetaToPlanetaDTO implements Converter<Planeta, PlanetaDTO> {

	@Override
	public PlanetaDTO convert(Planeta planeta) {
		PlanetaDTO planetaDTO = new PlanetaDTO();
		planetaDTO.setId(planeta.getId().toHexString());
		planetaDTO.setNome(planeta.getNome());
		planetaDTO.setClima(planeta.getClima());
		planetaDTO.setTerreno(planeta.getTerreno());
		planetaDTO.setQuantidadeFilmes(planeta.getQuantidadeFilmes());
		planetaDTO.setUrlPlaneta(PlanetaController.BASE_URL + "/" + planeta.getId().toHexString());
		return planetaDTO;
	}
}

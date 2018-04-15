package br.com.b2w.bit.starwars.api.v1.converters;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.b2w.bit.starwars.api.v1.commands.PlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.models.Planeta;

@Component
public class PlanetaDTOToPlaneta implements Converter<PlanetaDTO, Planeta> {

	@Override
	public Planeta convert(PlanetaDTO planetaDTO) {
		Planeta planeta = new Planeta();
		if (planetaDTO.getId() != null && !StringUtils.isEmpty(planetaDTO.getId())) {
			planeta.setId(new ObjectId(planetaDTO.getId()));
		}
		planeta.setNome(planetaDTO.getNome());
		planeta.setTerreno(planetaDTO.getTerreno());
		planeta.setClima(planetaDTO.getClima());
		return planeta;
	}
}

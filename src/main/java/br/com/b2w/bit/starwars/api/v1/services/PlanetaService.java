package br.com.b2w.bit.starwars.api.v1.services;

import java.util.List;

import br.com.b2w.bit.starwars.api.v1.commands.PlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;

public interface PlanetaService {
	
	List<PlanetaDTO> list(PlanetaParam planetaParam);

	PlanetaDTO getById(String id);
	
	PlanetaDTO save(Planeta planeta);
	
	void delete(String id);
}

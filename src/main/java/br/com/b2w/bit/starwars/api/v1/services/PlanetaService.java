package br.com.b2w.bit.starwars.api.v1.services;

import java.util.List;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;

public interface PlanetaService {
	
	List<Planeta> list(PlanetaParam planetaParam);

	Planeta getById(String id);
	
	Planeta save(Planeta planeta);
	
	void delete(String id);
}

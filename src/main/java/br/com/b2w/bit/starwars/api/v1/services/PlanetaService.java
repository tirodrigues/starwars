package br.com.b2w.bit.starwars.api.v1.services;

import java.util.List;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;

public interface PlanetaService {
	
	List<Planeta> list(String nome);

	Planeta getById(String id);
	
	Planeta save(Planeta planeta);
	
	void delete(String id);
}

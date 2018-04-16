package br.com.b2w.bit.starwars.api.v1.repositories;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;

public interface PlanetaRepositoryCustom {

	Iterable<Planeta> list(String nome);
}

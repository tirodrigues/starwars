package br.com.b2w.bit.starwars.api.v1.repositories;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;

public interface PlanetaRepositoryCustom {

	Iterable<Planeta> list(PlanetaParam planetaParam);
}

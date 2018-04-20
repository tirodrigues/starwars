package br.com.b2w.bit.starwars.api.v1.repositories;

import java.util.List;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;

public interface PlanetaRepositoryCustom {

	List<Planeta> list(PlanetaParam planetaParam);
}

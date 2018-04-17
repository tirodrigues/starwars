package br.com.b2w.bit.starwars.api.v1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b2w.bit.starwars.api.v1.exceptions.PlanetaNotFoundException;
import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;
import br.com.b2w.bit.starwars.api.v1.repositories.PlanetaRepository;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	private final PlanetaRepository planetaRepository;

	@Autowired
	public PlanetaServiceImpl(PlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}

	@Override
	public List<Planeta> list(PlanetaParam planetaParam) {
		List<Planeta> planetas = new ArrayList<>();

		planetaRepository.list(planetaParam).forEach(planetas::add);

		if (planetas.size() == 0) {
			throw new PlanetaNotFoundException();
		}

		return planetas;
	}

	@Override
	public Planeta getById(String id) {
		return planetaRepository.findById(id).orElseThrow(PlanetaNotFoundException::new);
	}

	@Override
	public Planeta save(Planeta planeta) {
		return planetaRepository.save(planeta);
	}

	@Override
	public void delete(String id) {
		planetaRepository.delete(getById(id));
	}
}

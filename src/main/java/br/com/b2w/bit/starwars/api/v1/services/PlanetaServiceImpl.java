package br.com.b2w.bit.starwars.api.v1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b2w.bit.starwars.api.v1.commands.PlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.converters.PlanetaDTOToPlaneta;
import br.com.b2w.bit.starwars.api.v1.converters.PlanetaToPlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.exceptions.PlanetaNotFoundException;
import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;
import br.com.b2w.bit.starwars.api.v1.repositories.PlanetaRepository;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	private final PlanetaRepository planetaRepository;
	private final PlanetaToPlanetaDTO planetaToPlanetaDTO;

	@Autowired
	public PlanetaServiceImpl(PlanetaRepository planetaRepository,
							  PlanetaToPlanetaDTO planetaToPlanetaDTO,
							  PlanetaDTOToPlaneta planetaDTOToPlaneta) {
		this.planetaRepository = planetaRepository;
		this.planetaToPlanetaDTO = planetaToPlanetaDTO;
	}

	@Override
	public List<PlanetaDTO> list(PlanetaParam planetaParam) {
		List<PlanetaDTO> planetas = planetaRepository.list(planetaParam).stream()
				.map(planetaToPlanetaDTO::convert)
				.collect(Collectors.toList());

		if (planetas.size() == 0) {
			throw new PlanetaNotFoundException();
		}

		return planetas;
	}

	@Override
	public PlanetaDTO getById(String id) {
		return planetaRepository.findById(id)
				.map(planetaToPlanetaDTO::convert)
				.orElseThrow(PlanetaNotFoundException::new);
	}

	@Override
	public PlanetaDTO save(Planeta planeta) {
		return planetaToPlanetaDTO.convert(planetaRepository.save(planeta));
	}

	@Override
	public void delete(String id) {
		planetaRepository.deleteById(id);
	}
}

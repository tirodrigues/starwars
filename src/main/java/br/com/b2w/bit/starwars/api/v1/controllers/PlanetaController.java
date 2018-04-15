package br.com.b2w.bit.starwars.api.v1.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.bit.starwars.api.v1.commands.PlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.converters.PlanetaDTOToPlaneta;
import br.com.b2w.bit.starwars.api.v1.converters.PlanetaToPlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.services.PlanetaService;

@RestController
@RequestMapping(PlanetaController.BASE_URL)
public class PlanetaController {

	public static final String BASE_URL = "/api/v1/planeta";

	private final PlanetaService planetaService;
	private final PlanetaToPlanetaDTO planetaToPlanetaDTO;
	private final PlanetaDTOToPlaneta planetaDTOToPlaneta;

	@Autowired
	public PlanetaController(PlanetaService planetaService, 
							 PlanetaToPlanetaDTO planetaToPlanetaDTO,
							 PlanetaDTOToPlaneta planetaDTOToPlaneta) {
		this.planetaService = planetaService;
		this.planetaToPlanetaDTO = planetaToPlanetaDTO;
		this.planetaDTOToPlaneta = planetaDTOToPlaneta;
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public PlanetaDTO getById(@PathVariable String id) {
		return planetaToPlanetaDTO.convert(planetaService.getById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@Valid @RequestBody PlanetaDTO planetaDTO) {
		planetaService.save(planetaDTOToPlaneta.convert(planetaDTO));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable String id) {
		planetaService.delete(id);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<PlanetaDTO> list(@RequestParam(value = "nome", required = false) String nome) {
		return planetaService.list(nome).stream().map(planeta -> {
			return planetaToPlanetaDTO.convert(planeta);
		}).collect(Collectors.toList());
	}
}

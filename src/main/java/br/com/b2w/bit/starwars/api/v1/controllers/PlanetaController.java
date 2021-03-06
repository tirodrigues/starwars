package br.com.b2w.bit.starwars.api.v1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.bit.starwars.api.v1.commands.PlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.converters.PlanetaDTOToPlaneta;
import br.com.b2w.bit.starwars.api.v1.integration.StarWarsIntegration;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;
import br.com.b2w.bit.starwars.api.v1.services.PlanetaService;
import io.swagger.annotations.Api;

@Api("API REST Planetas")
@RestController
@RequestMapping(PlanetaController.BASE_URL)
public class PlanetaController {

	public static final String BASE_URL = "/api/v1/planeta";

	private final PlanetaService planetaService;
	private final PlanetaDTOToPlaneta planetaDTOToPlaneta;
	private final StarWarsIntegration starWarsIntegration;

	@Autowired
	public PlanetaController(PlanetaService planetaService, 
							 PlanetaDTOToPlaneta planetaDTOToPlaneta,
							 StarWarsIntegration starWarsIntegration) {
		this.planetaService = planetaService;
		this.planetaDTOToPlaneta = planetaDTOToPlaneta;
		this.starWarsIntegration = starWarsIntegration;
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public PlanetaDTO getById(@PathVariable String id) {
		return planetaService.getById(id);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public PlanetaDTO save(@Valid @RequestBody PlanetaDTO planetaDTO) {
		Long quantidadeDeFilmes = starWarsIntegration.bucaQuantidadeDeFilmes(planetaDTO.getNome());
		planetaDTO.setQuantidadeFilmes(quantidadeDeFilmes);
		return planetaService.save(planetaDTOToPlaneta.convert(planetaDTO));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		planetaService.delete(id);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<PlanetaDTO> list(PlanetaParam planetaParam) {
		return planetaService.list(planetaParam);
	}
}

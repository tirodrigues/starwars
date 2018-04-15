package br.com.b2w.bit.starwars.api.v1.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.b2w.bit.starwars.api.v1.exceptions.RestResponseEntityExceptionHandler;
import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.services.PlanetaService;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlanetaControllerTest {

	@Mock
	PlanetaService planetaService;

	@InjectMocks
	PlanetaController planetaController;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(planetaController)
				.setControllerAdvice(new RestResponseEntityExceptionHandler()).build();
	}
	
    @Test
    public void testaListaPlanetas() throws Exception {
        Planeta planeta1 = new Planeta();
        planeta1.setNome("XXX");
        planeta1.setClima("Gelido");
        planeta1.setTerreno("Arenoso");

        Planeta planeta2 = new Planeta();
        planeta2.setNome("YYY");
        planeta2.setClima("Chuvoso");
        planeta2.setTerreno("Arenoso");

        List<Planeta> planetas = Arrays.asList(planeta1, planeta2);

        when(planetaService.list(anyString())).thenReturn(planetas);

        mockMvc.perform(get(PlanetaController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));
    }

}

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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.b2w.bit.starwars.api.v1.commands.PlanetaDTO;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParamBean;
import br.com.b2w.bit.starwars.api.v1.services.PlanetaService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class PlanetaControllerTest {

	@Mock
	PlanetaService planetaService;
	
	PlanetaParam planetaParam;
	
	@InjectMocks
	PlanetaController planetaController;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(planetaController).build();
		
		planetaParam = new PlanetaParamBean();
	}
	
    @Test
    public void testaListaPlanetas() throws Exception {
        PlanetaDTO planeta1 = new PlanetaDTO();
        planeta1.setNome("XXX");
        planeta1.setClima("Gelido");
        planeta1.setTerreno("Arenoso");

        PlanetaDTO planeta2 = new PlanetaDTO();
        planeta2.setNome("YYY");
        planeta2.setClima("Chuvoso");
        planeta2.setTerreno("Arenoso");

        List<PlanetaDTO> planetas = Arrays.asList(planeta1, planeta2);
        
        when(planetaService.list(any())).thenReturn(planetas);

        mockMvc.perform(get(PlanetaController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));
    }

}

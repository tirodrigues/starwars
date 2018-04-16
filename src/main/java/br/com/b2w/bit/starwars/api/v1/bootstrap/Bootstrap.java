package br.com.b2w.bit.starwars.api.v1.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.repositories.PlanetaRepository;

@Component
public class Bootstrap implements CommandLineRunner {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Deletando todo mundo deleteAll():");
		planetaRepository.deleteAll();
		
		//save planeta
		Planeta planeta = new Planeta();
		planeta.setNome("XYZ");
		planeta.setClima("Chuvoso");
		planeta.setTerreno("Gelido");
		
		Planeta planeta2 = new Planeta();
		planeta2.setNome("ZZZ");
		planeta2.setClima("111");
		planeta2.setTerreno("333");
		
		planetaRepository.save(planeta);
		
	}

}

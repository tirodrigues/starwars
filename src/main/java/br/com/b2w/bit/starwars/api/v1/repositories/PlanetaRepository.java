package br.com.b2w.bit.starwars.api.v1.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	
	Iterable<Planeta> findByNomeIgnoreCase(String nome);
}

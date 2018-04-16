package br.com.b2w.bit.starwars.api.v1.repositories;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;

public class PlanetaRepositoryImpl implements PlanetaRepositoryCustom {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public PlanetaRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Iterable<Planeta> list(String nome) {
		Query query = new Query();
		if(!Strings.isBlank(nome)) {
			query.addCriteria(Criteria.where("nome").regex(nome, "i"));
		}
		List<Planeta> planetas = mongoTemplate.find(query, Planeta.class);
		return planetas;
	}
}

package br.com.b2w.bit.starwars.api.v1.repositories;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.b2w.bit.starwars.api.v1.models.Planeta;
import br.com.b2w.bit.starwars.api.v1.param.PlanetaParam;

public class PlanetaRepositoryImpl implements PlanetaRepositoryCustom {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public PlanetaRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<Planeta> list(PlanetaParam planetaParam) {
		Query query = new Query();
		if(!Strings.isBlank(planetaParam.getNome())) {
			query.addCriteria(Criteria.where("nome").regex(planetaParam.getNome(), "i"));
		}
		return mongoTemplate.find(query, Planeta.class);
	}
}

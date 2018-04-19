package br.com.b2w.bit.starwars.api.v1.integration;

import java.io.Serializable;
import java.util.List;

public class PlanetaIntegratioResponse implements Serializable {

	private static final long serialVersionUID = -748141781325045312L;
	
	private Long count;
	private List<PlanetaIntegration> results;

	public List<PlanetaIntegration> getResults() {
		return results;
	}

	public void setResults(List<PlanetaIntegration> results) {
		this.results = results;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}

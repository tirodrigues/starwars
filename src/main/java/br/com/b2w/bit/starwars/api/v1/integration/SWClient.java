package br.com.b2w.bit.starwars.api.v1.integration;

import feign.Param;
import feign.RequestLine;

public interface SWClient {
	
	@RequestLine("GET /{nome}")
	PlanetaClient buscaPlanetaByName(@Param("nome") String nome);
}

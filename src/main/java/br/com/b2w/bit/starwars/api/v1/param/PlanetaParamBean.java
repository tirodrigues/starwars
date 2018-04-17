package br.com.b2w.bit.starwars.api.v1.param;

public class PlanetaParamBean implements PlanetaParam {

	private String nome;

	@Override
	public String getNome() {
		return this.nome;
	}

}

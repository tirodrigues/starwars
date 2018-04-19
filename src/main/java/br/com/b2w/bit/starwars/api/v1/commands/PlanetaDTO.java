package br.com.b2w.bit.starwars.api.v1.commands;

import javax.validation.constraints.NotBlank;

public class PlanetaDTO {

	private String id;

	@NotBlank
	private String nome;

	@NotBlank
	private String clima;

	@NotBlank
	private String terreno;

	private Long quantidadeFilmes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Long getQuantidadeFilmes() {
		return quantidadeFilmes;
	}

	public void setQuantidadeFilmes(Long quantidadeFilmes) {
		this.quantidadeFilmes = quantidadeFilmes;
	}
}
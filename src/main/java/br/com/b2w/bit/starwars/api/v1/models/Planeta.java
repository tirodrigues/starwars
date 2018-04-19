package br.com.b2w.bit.starwars.api.v1.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planeta {

	@Id
	private ObjectId id;
	private String nome;
	private String clima;
	private String terreno;
	private Long quantidadeFilmes;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public void setTerreno(String terrreno) {
		this.terreno = terrreno;
	}

	public Long getQuantidadeFilmes() {
		return quantidadeFilmes;
	}

	public void setQuantidadeFilmes(Long quantidadeFilmes) {
		this.quantidadeFilmes = quantidadeFilmes;
	}

}

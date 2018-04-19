package br.com.b2w.bit.starwars.api.v1.integration;

import java.io.Serializable;
import java.util.List;

public class PlanetaIntegration implements Serializable {

	private static final long serialVersionUID = 3847652007562661697L;
	
	private String edited;
	private List<String> starships;
	private List<String> species;
	private String skin_color;
	private String eye_color;
	private List<String> films;
	private String birth_year;
	private String url;
	private String mass;
	private String height;
	private String created;
	private String hair_color;
	private String name;
	private String gender;
	private String homeworld;
	private String[] vehicles;

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public List<String> getStarships() {
		return starships;
	}

	public void setStarships(List<String> starships) {
		this.starships = starships;
	}

	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
	}

	public String getSkin_color() {
		return skin_color;
	}

	public void setSkin_color(String skin_color) {
		this.skin_color = skin_color;
	}

	public String getEye_color() {
		return eye_color;
	}

	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getHair_color() {
		return hair_color;
	}

	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public String[] getVehicles() {
		return vehicles;
	}

	public void setVehicles(String[] vehicles) {
		this.vehicles = vehicles;
	}
}

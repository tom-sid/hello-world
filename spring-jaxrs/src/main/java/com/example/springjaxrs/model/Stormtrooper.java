package com.example.springjaxrs.model;

public class Stormtrooper {
	private String id;
	private String planetOfOrigin;
	private String species;
	private String type;

	public Stormtrooper() {
	}

	public Stormtrooper(String id, String planetOfOrigin, String species, String type) {
		super();
		this.id = id;
		this.planetOfOrigin = planetOfOrigin;
		this.species = species;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlanetOfOrigin() {
		return planetOfOrigin;
	}

	public void setPlanetOfOrigin(String planetOfOrigin) {
		this.planetOfOrigin = planetOfOrigin;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("Stormtrooper [id=%s, planetOfOrigin=%s, species=%s, type=%s]", id, planetOfOrigin,
				species, type);
	}

}

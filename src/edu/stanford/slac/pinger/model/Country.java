package edu.stanford.slac.pinger.model;

public class Country {
	
	
	private int id;
	private String name;
	private String country_code;
	private int population;
	private float area_in_sqkm;
	private String first_language;
	private String continent_code;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public float getArea_in_sqkm() {
		return area_in_sqkm;
	}
	public void setArea_in_sqkm(float area_in_sqkm) {
		this.area_in_sqkm = area_in_sqkm;
	}
	public String getFirst_language() {
		return first_language;
	}
	public void setFirst_language(String first_language) {
		this.first_language = first_language;
	}
	public String getContinent_code() {
		return continent_code;
	}
	public void setContinent_code(String continent_code) {
		this.continent_code = continent_code;
	}
	
	
	

}

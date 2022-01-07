package com.SpartaGlobal.Group1.withFramework.DTO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDTO{

	@JsonProperty("visibility")
	private int visibility;

	@JsonProperty("timezone")
	private int timezone;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("clouds")
	private Clouds clouds;

	@JsonProperty("sys")
	private Sys sys;

	@JsonProperty("dt")
	private int dt;

	@JsonProperty("coord")
	private Coord coord;

	@JsonProperty("weather")
	private List<WeatherItem> weather;

	@JsonProperty("name")
	private String name;

	@JsonProperty("cod")
	private int cod;

	@JsonProperty("id")
	private int id;

	@JsonProperty("base")
	private String base;

	@JsonProperty("wind")
	private Wind wind;

	public int getVisibility(){
		return visibility;
	}

	public int getTimezone(){
		return timezone;
	}

	public Main getMain(){
		return main;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public Sys getSys(){
		return sys;
	}

	public int getDt(){
		return dt;
	}

	public Coord getCoord(){
		return coord;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public String getName(){
		return name;
	}

	public int getCod(){
		return cod;
	}

	public int getId(){
		return id;
	}

	public String getBase(){
		return base;
	}

	public Wind getWind(){
		return wind;
	}
}


//{"coord":{"lon":-0.1257,"lat":51.5085},
// "weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],
// "base":"stations",
// "main":{"temp":278.29,"feels_like":274.84,"temp_min":276.69,"temp_max":279.26,"pressure":1009,"humidity":76},"visibility":10000,
// "wind":{"speed":4.63,"deg":240},
// "clouds":{"all":76},"dt":1641570500,
// "sys":{"type":2,"id":2019646,"country":"GB","sunrise":1641542673,"sunset":1641571708},
// "timezone":0, - TESTED
// "id":2643743,
// "name":"London", - TESTED
// "cod":200} - TESTED
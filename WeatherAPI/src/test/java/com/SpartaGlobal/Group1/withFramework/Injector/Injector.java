package com.SpartaGlobal.Group1.withFramework.Injector;

import com.SpartaGlobal.Group1.withFramework.DTO.WeatherDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Injector {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static WeatherDTO injectWeatherDTO(String path) {
        WeatherDTO weatherDTO = new WeatherDTO();
        try {
            weatherDTO = objectMapper.readValue(new URL(path), WeatherDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherDTO;
    }
}

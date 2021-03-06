package com.SpartaGlobal.Group1.withFramework;

import com.SpartaGlobal.Group1.withFramework.Connection.ConnectionManager;
import com.SpartaGlobal.Group1.withFramework.DTO.WeatherDTO;
import com.SpartaGlobal.Group1.withFramework.Injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeatherCountryTests {
    private static WeatherDTO weatherDTO;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionGivenCityAndCountry("birmingham", "gb"));
    }

    @Test
    @DisplayName("Test that correct name is returned")
    public void nameTest() {
        Assertions.assertEquals("Birmingham", weatherDTO.getName());
    }

    @Test
    @DisplayName("Test that country is correct")
    public void countryTest() {
        Assertions.assertEquals("GB", weatherDTO.getSys().getCountry());
    }

}

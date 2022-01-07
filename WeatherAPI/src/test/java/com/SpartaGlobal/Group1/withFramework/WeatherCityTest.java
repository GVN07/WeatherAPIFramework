package com.SpartaGlobal.Group1.withFramework;

import com.SpartaGlobal.Group1.withFramework.Connection.ConnectionManager;
import com.SpartaGlobal.Group1.withFramework.DTO.WeatherDTO;
import com.SpartaGlobal.Group1.withFramework.Injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeatherCityTest {
    private static WeatherDTO weatherDTO;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionGivenCity("london"));
    }

    @Test
    @DisplayName("Test that correct name is returned")
    public void nameTest(){
        Assertions.assertEquals("London", weatherDTO.getName());
    }

    @Test
    @DisplayName("Given London as location, the cod is correct")
    public void codTest() {
        Assertions.assertEquals(200, weatherDTO.getCod());
    }

    @Test
    @DisplayName("Given Location is London, Timezone is correct")
    public void timezoneTest() {
        Assertions.assertEquals(0, weatherDTO.getTimezone());
    }
}

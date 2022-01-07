package com.SpartaGlobal.Group1.withFramework;

import com.SpartaGlobal.Group1.withFramework.Connection.ConnectionManager;
import com.SpartaGlobal.Group1.withFramework.DTO.WeatherDTO;
import com.SpartaGlobal.Group1.withFramework.Injector.Injector;
import org.junit.jupiter.api.*;

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

    @Test
    @DisplayName("Checking ID for London is correct")
    public void idTest() {
        Assertions.assertEquals(2643743, weatherDTO.getId());
    }

    @Nested
    public class CoordinatesTests {
        @Test
        @DisplayName("Checking longitude for London is correct")
        public void lonTest() {
            Assertions.assertEquals(-0.1257, weatherDTO.getCoord().getLon());
        }

        @Test
        @DisplayName("Checking latitude for London is correct")
        public void latTest() {
            Assertions.assertEquals(51.5085, weatherDTO.getCoord().getLat());
        }
    }


    @Test
    @DisplayName("Test that country is correct")
    public void countryTest(){
        Assertions.assertEquals("GB", weatherDTO.getSys().getCountry());
    }
}

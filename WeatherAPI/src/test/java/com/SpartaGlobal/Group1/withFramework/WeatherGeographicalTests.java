package com.SpartaGlobal.Group1.withFramework;

import com.SpartaGlobal.Group1.withFramework.Connection.ConnectionManager;
import com.SpartaGlobal.Group1.withFramework.DTO.WeatherDTO;
import com.SpartaGlobal.Group1.withFramework.Injector.Injector;
import org.junit.jupiter.api.*;

public class WeatherGeographicalTests {
    private static WeatherDTO weatherDTO;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionGivenGeographicalCoordinates(35, 139));
    }

    @Test
    @DisplayName("Test that correct name is returned")
    public void nameTest(){
        Assertions.assertEquals("Shuzenji", weatherDTO.getName());
    }

    @Test
    @DisplayName("Invalid input shows 400 code")
    public void invalidInput400Test() {
        int statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionGivenGeographicalCoordinates(100, 100));
        Assertions.assertEquals(400, statusCode);
    }
}

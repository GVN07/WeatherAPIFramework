package com.SpartaGlobal.Group1.withFramework;

import com.SpartaGlobal.Group1.withFramework.Connection.ConnectionManager;
import com.SpartaGlobal.Group1.withFramework.DTO.WeatherDTO;
import com.SpartaGlobal.Group1.withFramework.Injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeatherIdTests {
    private static WeatherDTO weatherDTO;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionGivenCityID(2643743));
    }

    @Test
    @DisplayName("Checking City ID is correct")
    public void cityIDTest (){
        Assertions.assertEquals(2643743, weatherDTO.getId());
    }

    @Test
    @DisplayName("Invalid input shows 400 code")
    public void invalidInput400Test() {
        int statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionGivenCityID(-1));
        Assertions.assertEquals(400, statusCode);
    }
}

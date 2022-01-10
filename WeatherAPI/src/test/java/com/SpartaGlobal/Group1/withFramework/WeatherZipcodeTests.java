package com.SpartaGlobal.Group1.withFramework;

import com.SpartaGlobal.Group1.withFramework.Connection.ConnectionManager;
import com.SpartaGlobal.Group1.withFramework.DTO.WeatherDTO;
import com.SpartaGlobal.Group1.withFramework.Injector.Injector;
import org.junit.jupiter.api.*;

public class WeatherZipcodeTests {
    private static WeatherDTO weatherDTO;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionGivenZip("94040", "US"));
    }

    @Test
    @DisplayName("Test that correct name is returned")
    public void nameTest(){
        Assertions.assertEquals("Mountain View", weatherDTO.getName());
    }

    @Nested
    public class InvalidInputTests {
        @Test
        @DisplayName("Invalid input shows 400 code")
        public void invalidInput400Test() {
            int statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionGivenZip("", "GB"));
            Assertions.assertEquals(400, statusCode);
        }

        @Test
        @DisplayName("Invalid input shows 404 code")
        public void invalidInput404Test() {
            int statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionGivenZip("-2643743", "GB"));
            Assertions.assertEquals(404, statusCode);
        }
    }

}

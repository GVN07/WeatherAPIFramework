package com.SpartaGlobal.Group1.withFramework;

import com.SpartaGlobal.Group1.withFramework.Connection.ConnectionManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;

public class WeatherFrameworkTests {
    private static int statusCode;
    private static HashMap<String, String> headers;

    @BeforeAll
    public static void init() {
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionGivenCity("london"));
        String longHeaders = ConnectionManager.getLongVersionHeader(ConnectionManager.getConnectionGivenCity("london"));
        headers = ConnectionManager.getHeaders(longHeaders);
    }

    @Test
    @DisplayName("Test status code")
    public void testStatusCode() {
        Assertions.assertEquals(200, statusCode);
    }

    @Nested
    public class HeadersTests {
        @Test
        @DisplayName("Check that the correct number of headers have been found")
        public void headerNumberTest() {
            Assertions.assertEquals(9, headers.size());
        }

        @ParameterizedTest
        @CsvSource({
                "access-control-allow-origin, *",
                "content-length, 475",
                "server, openresty",
                "access-control-allow-credentials, true",
                "x-cache-key, /data/2.5/weather?q=london",
                "connection, keep-alive",
                "content-type, application/json; charset=utf-8"
        })
        @DisplayName("Test if the header values are correct for those that don't have commas inside")
        public void headersTest(String key, String value) {
            Assertions.assertEquals(value, headers.get(key));
        }

        @Nested
        public class CommaHeadersTests {
            // date and time change
//            @Test
//            @DisplayName("date header test")
//            public void dateHeaderTest() {
//                Assertions.assertEquals("Mon, 10 Jan 2022 14:50:48 GMT", headers.get("date"));
//            }

            @Test
            @DisplayName("access-control-allow-methods header test")
            public void AccessControlAllowMethodsHeaderTest() {
                Assertions.assertEquals("GET, POST", headers.get("access-control-allow-methods"));
            }
        }
    }

}

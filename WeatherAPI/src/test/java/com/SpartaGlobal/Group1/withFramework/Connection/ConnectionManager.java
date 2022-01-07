package com.SpartaGlobal.Group1.withFramework.Connection;

import com.SpartaGlobal.Group1.withFramework.ConfigReader;

public class ConnectionManager {
    private static final String BASEURL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String KEY = ConfigReader.getConfigKey();

    public static String getConnectionGivenCity(String city) {
        return BASEURL + "?q=" + city + "&appid=" + KEY;
    }

    public static String getConnectionGivenCityAndCountry(String city, String country) {
        return BASEURL + "?q=" + city +",\"\"," + country + "&appid=" + KEY;
    }
}

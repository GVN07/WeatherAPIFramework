package com.SpartaGlobal.Group1.withFramework.Connection;

import com.SpartaGlobal.Group1.withFramework.ConfigReader;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static java.net.URI.create;

public class ConnectionManager {
    private static final String BASEURL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String KEY = ConfigReader.getConfigKey();

    public static String getConnectionGivenCity(String city) {
        return BASEURL + "?q=" + city + "&appid=" + KEY;
    }

    public static String getConnectionGivenCityAndCountry(String city, String country) {
        return BASEURL + "?q=" + city +",\"\"," + country + "&appid=" + KEY;
    }

    public static String getConnectionGivenCityID(int id){
        return BASEURL + "?id=" + id + "&appid=" + KEY;
    }

    public static String getConnectionGivenZip(String zip, String country) {
        return BASEURL + "?zip=" + zip + "," + country + "&appid=" + KEY;
    }

    public static String getConnectionGivenGeographicalCoordinates(double lat, double lon) {
        return BASEURL + "?lat=" + lat + "&lon=" + lon + "&appid=" + KEY;
    }

    private static HttpResponse<String> getStringHttpResponse(String connection) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(create(connection))
                .build();
        HttpResponse<String> httpResponse = null;

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public static int getStatusCode(String connection) {
        HttpResponse<String> httpResponse = getStringHttpResponse(connection);

        return httpResponse.statusCode();
    }

    public static String getLongVersionHeader(String connection) {
        HttpResponse<String> httpResponse = getStringHttpResponse(connection);
        return httpResponse.headers().toString();
    }

    public static HashMap<String, String> getHeaders(String longHeaders) {
        HashMap<String, String> headers = new HashMap<>();
        longHeaders = longHeaders.substring(longHeaders.indexOf('{'));
        longHeaders = longHeaders.substring(3, longHeaders.length() - 3);
        String[] headersList = longHeaders.split("], ");
        headersList[headersList.length - 1] = headersList[headersList.length - 1].substring(0, headersList[headersList.length - 1].indexOf(']'));
        for(String header : headersList) {
            headers.put(header.substring(0, header.indexOf('=')), header.substring(header.indexOf('[') + 1));
        }
        return headers;
    }
}


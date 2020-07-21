package com.example.WheatherChannel;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class Main {

    private final String baseUrl = "https://api.openweathermap.org/data/2.5/";
    private final String apiKey = "eeaa2794e72b5067a7b7da9f2fe49428";
    private Gson gson;
    String city;

    public Main(){
        gson = new Gson();
    }

    public WeatherConditions loadCurrentWeather(String city) {

        String url = baseUrl + "weather" +
                "?q=" + city +
                "&units=imperial" +
                "&apiKey=" + apiKey;
        String data = loadJsonData(url);

    return gson.fromJson(data, WeatherConditions.class);
    }

    public WeatherForecast loadWeatherForecast(String city) {

        String url = baseUrl + "forecast" +
                "?q=" + city +
                "&units=imperial" +
                "&apiKey=" + apiKey;
        String data = loadJsonData(url);
        return gson.fromJson(data, WeatherForecast.class);
    }
    private String loadJsonData(String url) {
        StringBuilder data = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    data.append(line);
                }
            }
            while (line != null);
            return data.toString();
        } catch (IOException ioe) {
            System.out.println("Error reading HTTP: " + ioe);
        }
        return data.toString();
    }
}

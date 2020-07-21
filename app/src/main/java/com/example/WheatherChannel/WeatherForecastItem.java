package com.example.WheatherChannel;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class WeatherForecastItem {

    @SerializedName("dt_txt")
    private String time;
    @SerializedName("main")
    private Map<String,Float> measurements;
    private Temperature temperature;
    @SerializedName("weather")
    private List<WeatherDescription> description;
    private WeatherWind wind;


    public String getTime() { return time; }
    public Map<String, Float> getMeasurements() { return measurements; }
    public List<WeatherDescription> getWeather() { return description; }
    public WeatherWind getWind() { return wind; }
    @Override
    public String toString() {
        return " - Time: " + time + ',' +
                " - Temperature: " + temperature.getTemp() + ',' +
                " - Weather Conditions: " + description.get(0).getDescription() + ',' +
                " - Wind Speed: " + wind.getSpeed() + '\n';
    }
}

package com.school21.simulator;

import com.school21.simulator.vehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4];
    }
}

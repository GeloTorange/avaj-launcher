package com.school21.simulator;

import com.school21.simulator.vehicles.Coordinates;
public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        super.conditionsChanged();
    }
}

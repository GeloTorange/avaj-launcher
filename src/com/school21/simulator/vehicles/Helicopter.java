package com.school21.simulator.vehicles;

import com.school21.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter (String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = null;
    }

    @Override
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("SUN"))
            Coordinates.updateCoordinate(coordinates, new int[]{10, 0, 2});
        else if (weather.equals("RAIN"))
            Coordinates.updateCoordinate(coordinates, new int[]{5, 0, 0});
        else if (weather.equals("FOG"))
            Coordinates.updateCoordinate(coordinates, new int[]{1, 0, 0});
        else if (weather.equals("SNOW"))
            Coordinates.updateCoordinate(coordinates, new int[]{0, 0, -12});
        System.out.println(this.toString() + "It's " + weather);
        if (coordinates.getHeight() <= 0)
            weatherTower.unregister(this);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    @Override
    public String toString() {
        return ("Helicopter: " + this.name + "(" + this.id + ")");
    }
}

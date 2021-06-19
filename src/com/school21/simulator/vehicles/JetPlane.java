package com.school21.simulator.vehicles;

import com.school21.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlane (String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = null;
    }

    @Override
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        int[] changes;
        if (weather.equals("SUN"))
            changes = new int[]{10, 0, 2};
        else if (weather.equals("RAIN"))
            changes = new int[]{0, 5, 0};
        else if (weather.equals("FOG"))
            changes = new int[]{0, 1, 0};
        else if (weather.equals("SNOW"))
            changes = new int[]{0, 0, -12};
        else
            changes = null;
        System.out.println(this.toString() + "It's " + weather);
        this.coordinates = Coordinates.updateCoordinate(coordinates, changes);
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
        return ("JetPlane: " + this.name + "(" + this.id + ")");
    }
}

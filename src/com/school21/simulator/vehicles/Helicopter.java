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
        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                System.out.println(this.toString() + "It's SUN");
                this.coordinates = Coordinates.updateCoordinate(coordinates, 2, 0, 4);
                break;
            case "RAIN":
                System.out.println(this.toString() + "It's RAIN");
                this.coordinates = Coordinates.updateCoordinate(coordinates, 0, 0, -5);
                break;
            case "FOG":
                System.out.println(this.toString() + "It's FOG");
                this.coordinates = Coordinates.updateCoordinate(coordinates, 0, 0, -3);
                break;
            case "SNOW":
                System.out.println(this.toString() + "It's SNOW");
                this.coordinates = Coordinates.updateCoordinate(coordinates, 0, 0, -15);
                break;
        }
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

package com.school21.simulator.vehicles;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public static Coordinates updateCoordinate(Coordinates coordinates, int[] changes) {
        coordinates.longitude += changes[0];
        coordinates.latitude += changes[1];
        if ((coordinates.height += changes[2]) > 100)
            coordinates.height = 100;
        return coordinates;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}

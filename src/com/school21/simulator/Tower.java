package com.school21.simulator;

import com.school21.simulator.vehicles.Flyable;

import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        System.out.println("Tower: " + flyable.toString() + " registred!");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        System.out.println("Башня: " + flyable.toString() + " unregistered!");
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
    }


}

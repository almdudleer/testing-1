package com.almdudleer.labs.testing.lab1.hitchhikers;

import com.almdudleer.labs.testing.lab1.hitchhikers.enumeration.WorldType;

public class Planet extends Location {
    public Planet() {
        super();
    }

    public Planet(WorldType worldType) {
        super(worldType);
    }

    public Planet(String name, WorldType worldType) {
        super(name, worldType);
    }
}

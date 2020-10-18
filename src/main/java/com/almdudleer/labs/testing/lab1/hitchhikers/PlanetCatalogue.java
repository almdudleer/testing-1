package com.almdudleer.labs.testing.lab1.hitchhikers;

import com.almdudleer.labs.testing.lab1.hitchhikers.enumeration.WorldType;

import java.util.ArrayList;
import java.util.List;

public class PlanetCatalogue extends Location {
    public List<Planet> planets = new ArrayList<>();

    public PlanetCatalogue() {
        super(WorldType.VIRTUAL);
    }
}

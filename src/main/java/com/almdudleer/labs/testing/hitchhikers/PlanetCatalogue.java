package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.WorldType;

import java.util.ArrayList;
import java.util.List;

public class PlanetCatalogue extends Location {
    public List<Planet> planets = new ArrayList<>();

    public PlanetCatalogue() {
        super(WorldType.VIRTUAL);
    }
}

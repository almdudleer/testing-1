package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.WorldType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public abstract class Location {
    final WorldType worldType;
    String name;
    Collection<Character> charactersHere = new ArrayList<>();
    Collection<Thing> thingsHere = new ArrayList<>();

    public Location(String name, WorldType worldType) {
        this.name = name;
        this.worldType = worldType;
    }

    public Location(WorldType worldType) {
        this.name = "Unnamed " + this.getClass().getSimpleName();
        this.worldType = worldType;
    }

    public Location() {
        this(WorldType.REAL);
    }

}

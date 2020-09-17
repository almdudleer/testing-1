package com.almdudleer.labs.testing.hitchhikers;

public class Character {
    Location location;

    public boolean move(Location location) {
        this.location = location;
        return true;
    }
}

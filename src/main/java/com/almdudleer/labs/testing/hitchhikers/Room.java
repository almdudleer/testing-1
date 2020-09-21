package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.WorldType;

public class Room extends Location {
    public Room() {
        super();
    }

    public Room(WorldType worldType) {
        super(worldType);
    }

    public Room(String name, WorldType worldType) {
        super(name, worldType);
    }
}

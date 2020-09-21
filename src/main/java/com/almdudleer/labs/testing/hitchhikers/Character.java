package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterState;
import com.almdudleer.labs.testing.hitchhikers.exceptions.ThingNotFoundInCurrentLocationException;
import lombok.Data;

@Data
public class Character {
    String name;
    Location location;
    CharacterState state;

    public Character(String name, Location location) {
        this.name = name;
        this.location = location;
        this.location.getCharactersHere().add(this);
    }

    public void move(Location location) {
        System.out.println(name + " tries to move to " + location.getName());
        this.location.getCharactersHere().remove(this);
        this.location = location;
        this.location.getCharactersHere().add(this);
        System.out.println(name + " moves to " + location.getName());
    }

    public void interactWith(Thing thing) throws ThingNotFoundInCurrentLocationException {
        System.out.println(name + " tries to interact with " + thing.getName());
        if (!location.getThingsHere().contains(thing)) {
            System.out.println(name + " couldn't interact with "
                    + thing.getName() + ", because " + name
                    + " is in " + location.getName() + " and "
                    + thing.getName() + " is not there."
            );
            throw new ThingNotFoundInCurrentLocationException("Вещь \"" + thing.getName() + "\" не найдена в текущей локации");
        }
        thing.onInteract(this);
    }
}

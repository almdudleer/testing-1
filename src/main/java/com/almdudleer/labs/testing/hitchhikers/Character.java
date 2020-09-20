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
        this.location.getCharactersHere().remove(this);
        this.location = location;
        this.location.getCharactersHere().add(this);
    }

    public void interactWith(Thing thing) throws ThingNotFoundInCurrentLocationException {
        if (!location.getThingsHere().contains(thing)) {
            throw new ThingNotFoundInCurrentLocationException("Вещь \"" + thing.getName() + "\" не найдена в текущей локации");
        }
        thing.onInteract(this);
    }
}

package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterState;
import com.almdudleer.labs.testing.hitchhikers.exceptions.ThingNotFoundInCurrentLocationException;
import lombok.Data;

@Data
public class Character {
    Location location;
    CharacterState state;

    public void move(Location location) {
        this.location = location;
    }

    public void interactWith(Thing thing) throws ThingNotFoundInCurrentLocationException {
        if (!location.getThingsHere().contains(thing)) {
            throw new ThingNotFoundInCurrentLocationException("Вещь \"" + thing.getName() + "\" не найдена в текущей локации");
        }
        thing.onInteract(this);
    }
}

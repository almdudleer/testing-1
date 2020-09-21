package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterInteractionType;
import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterState;
import com.almdudleer.labs.testing.hitchhikers.enumeration.Race;
import com.almdudleer.labs.testing.hitchhikers.exceptions.CharacterNotFoundInCurrentLocationException;
import com.almdudleer.labs.testing.hitchhikers.exceptions.ThingNotFoundInCurrentLocationException;
import lombok.Data;

@Data
public class Character {
    String name;
    Race race;
    Location location;
    CharacterState state;

    public Character(String name, Location location) {
        this(name, location, Race.HUMAN);
    }

    public Character(String name, Location location, Race race) {
        if (name == null) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
        this.state = CharacterState.IDLE;
        this.race = race;
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

    public void interactWith(Character character, CharacterInteractionType interactionType) throws CharacterNotFoundInCurrentLocationException {
        System.out.println(name + " tries to interact with " + character.getName() + " by " + interactionType);
        if (!location.getCharactersHere().contains(character)) {
            System.out.println(name + " couldn't interact with "
                    + character.getName() + ", because " + name
                    + " is in " + location.getName() + " and "
                    + character.getName() + " is not there."
            );
            throw new CharacterNotFoundInCurrentLocationException("Персонаж \"" + character.getName() + "\" не найден в текущей локации");
        }
        switch (interactionType) {
            case LOOK:
                System.out.println(race + " " + name + " looks at " + character.getRace() + " " + character.getName());
                this.setState(CharacterState.LOOKING);
                break;
            case TALK:
                System.out.println(race + " " + name + " talks with " + character.getRace() + " " + character.getName());
                this.setState(CharacterState.TALKING);
                break;
        }
        character.onInteract(this, interactionType);
    }

    private void onInteract(Character character, CharacterInteractionType interactionType) {
        if (interactionType == CharacterInteractionType.TALK) {
            System.out.println(name + " talks back with " + character.getName());
            this.setState(CharacterState.TALKING);
        }
    }
}

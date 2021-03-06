package com.almdudleer.labs.testing.lab1.hitchhikers;

import com.almdudleer.labs.testing.lab1.hitchhikers.enumeration.CharacterState;

public class Sofa extends Thing {
    public Sofa(String name) {
        super(name);
    }

    @Override
    public void onInteract(Character character) {
        System.out.println(character.getName() + " sits on " + this.getName());
        character.setState(CharacterState.SITTING);
    }
}

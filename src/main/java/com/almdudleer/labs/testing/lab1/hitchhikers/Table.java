package com.almdudleer.labs.testing.lab1.hitchhikers;

import com.almdudleer.labs.testing.lab1.hitchhikers.enumeration.CharacterState;

public class Table extends Thing {

    public Table(String name) {
        super(name);
    }

    @Override
    public void onInteract(Character character) {
        System.out.println(character.getName() + " is drinking tea at " + this.getName());
        character.setState(CharacterState.TEA_DRINKING);
    }
}

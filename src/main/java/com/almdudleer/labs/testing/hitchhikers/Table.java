package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterState;

public class Table extends Thing {

    public Table(String name) {
        super(name);
    }

    @Override
    public void onInteract(Character character) {
        character.setState(CharacterState.TEA_DRINKING);
    }
}

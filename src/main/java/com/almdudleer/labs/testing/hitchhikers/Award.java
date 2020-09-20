package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterState;

public class Award extends Thing {
    public Award(String name) {
        super(name);
    }

    @Override
    public void onInteract(Character character) {
        character.setState(CharacterState.ADMIRING);
    }
}

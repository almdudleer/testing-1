package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterState;

public class Sofa extends Thing {
    public Sofa(String name) {
        super(name);
    }

    @Override
    public void onInteract(Character character) {
    character.setState(CharacterState.SITTING);
    }
}

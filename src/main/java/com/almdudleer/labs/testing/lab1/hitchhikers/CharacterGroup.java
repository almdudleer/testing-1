package com.almdudleer.labs.testing.lab1.hitchhikers;

import java.util.HashSet;

public class CharacterGroup extends HashSet<Character> {
    public void move(Location location) {
        this.forEach(character -> character.move(location));
    }
}

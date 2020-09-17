package com.almdudleer.labs.testing.hitchhikers;

import java.util.HashSet;

public class CharacterGroup extends HashSet<Character> {
    public boolean move(Location location) {
        return this.stream().allMatch(character -> character.move(location));
    }
}
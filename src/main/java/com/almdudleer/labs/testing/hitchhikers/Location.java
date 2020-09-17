package com.almdudleer.labs.testing.hitchhikers;

import java.util.Collection;

public class Location {
    WorldType worldType;
    Collection<? extends Character> charactersHere;
    Collection<? extends Thing> thingsHere;
}

package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.WorldType;
import lombok.Getter;

import java.util.Collection;


public class Location {
    WorldType worldType;
    @Getter
    Collection<? extends Character> charactersHere;
    @Getter
    Collection<? extends Thing> thingsHere;
}

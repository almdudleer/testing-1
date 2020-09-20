package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.WorldType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@RequiredArgsConstructor
public abstract class Location {
    final WorldType worldType;
    Collection<Character> charactersHere = new ArrayList<>();
    Collection<Thing> thingsHere = new ArrayList<>();

}

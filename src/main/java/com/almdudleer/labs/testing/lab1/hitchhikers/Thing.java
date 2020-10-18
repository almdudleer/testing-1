package com.almdudleer.labs.testing.lab1.hitchhikers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class Thing {
    @Getter
    final String name;

    public abstract void onInteract(Character character);
}

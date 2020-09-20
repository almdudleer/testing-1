package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterState;
import com.almdudleer.labs.testing.hitchhikers.enumeration.WorldType;
import com.almdudleer.labs.testing.hitchhikers.exceptions.ThingNotFoundInCurrentLocationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HitchHikersTest {

    Character alice;
    Character bob;
    Character lyosha;
    Room room;
    PlanetCatalogue planetCalalogue;
    CharacterGroup characterGroup;
    Award award;
    Sofa sofa;
    Table table;

    @BeforeEach
    void initObjects() {
        room = new Room();
        planetCalalogue = new PlanetCatalogue();
        alice = new Character("Алиса", planetCalalogue);
        bob = new Character("Боб", planetCalalogue);
        lyosha = new Character("Лёша", planetCalalogue);
        characterGroup = new CharacterGroup();
        characterGroup.add(alice);
        characterGroup.add(bob);
        characterGroup.add(lyosha);
        award = new Award("Награда");
        sofa = new Sofa("Обитый плюшем диван");
        table = new Table("Стеклянный столик");
    }

    @Test
    void moveCharacter() {
        assertEquals(alice.location, planetCalalogue);
        alice.move(room);
        assertTrue(room.charactersHere.contains(alice));
        assertEquals(alice.location, room);
        alice.move(planetCalalogue);
        assertTrue(planetCalalogue.charactersHere.contains(alice));
        assertEquals(alice.location, planetCalalogue);
    }

    @Test
    void moveCharacterGroup() {
        characterGroup.move(room);
        assertTrue(planetCalalogue.charactersHere.isEmpty());
        characterGroup.forEach(character -> assertEquals(character.location, room));
        characterGroup.forEach(character -> assertTrue(room.charactersHere.contains(character)));
    }

    @Test
    void testInteractionWithThingFromAnotherLocation() {
        room.thingsHere.add(table);
        room.thingsHere.add(sofa);
        room.thingsHere.add(award);
        assertThrows(ThingNotFoundInCurrentLocationException.class, () -> alice.interactWith(table));
        assertThrows(ThingNotFoundInCurrentLocationException.class, () -> alice.interactWith(sofa));
        assertThrows(ThingNotFoundInCurrentLocationException.class, () -> alice.interactWith(award));
    }

    @Test
    void testInteractionWithSofa() {
        planetCalalogue.thingsHere.add(sofa);
        lyosha.interactWith(sofa);
        assertEquals(lyosha.state, CharacterState.SITTING);
    }

    @Test
    void testInteractionWithTable() {
        planetCalalogue.thingsHere.add(table);
        lyosha.interactWith(table);
        assertEquals(lyosha.state, CharacterState.TEA_DRINKING);
    }

    @Test
    void testInteractionWithAward() {
        planetCalalogue.thingsHere.add(award);
        lyosha.interactWith(award);
        assertEquals(lyosha.state, CharacterState.ADMIRING);
    }

    @Test
    void testInteractionWithThings() {
        planetCalalogue.thingsHere.add(sofa);
        planetCalalogue.thingsHere.add(table);
        planetCalalogue.thingsHere.add(award);
        lyosha.interactWith(sofa);
        assertEquals(lyosha.state, CharacterState.SITTING);
        lyosha.interactWith(table);
        assertEquals(lyosha.state, CharacterState.TEA_DRINKING);
        lyosha.interactWith(award);
        assertEquals(lyosha.state, CharacterState.ADMIRING);
    }
}

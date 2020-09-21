package com.almdudleer.labs.testing.hitchhikers;

import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterInteractionType;
import com.almdudleer.labs.testing.hitchhikers.enumeration.CharacterState;
import com.almdudleer.labs.testing.hitchhikers.enumeration.Race;
import com.almdudleer.labs.testing.hitchhikers.exceptions.CharacterNotFoundInCurrentLocationException;
import com.almdudleer.labs.testing.hitchhikers.exceptions.ThingNotFoundInCurrentLocationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HitchHikersTest {

    Character alice;
    Character bob;
    Character lyosha;
    Character magrathean;
    Room room;
    PlanetCatalogue planetCatalogue;
    CharacterGroup characterGroup;
    Award award;
    Sofa sofa;
    Table table;

    @BeforeEach
    void initObjects() {
        room = new Room();
        planetCatalogue = new PlanetCatalogue();
        magrathean = new Character(null, room, Race.MAGRATHEAN);
        alice = new Character("Алиса", planetCatalogue);
        bob = new Character("Боб", planetCatalogue);
        lyosha = new Character("Лёша", planetCatalogue);
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
        assertEquals(alice.location, planetCatalogue);
        alice.move(room);
        assertTrue(room.charactersHere.contains(alice));
        assertEquals(alice.location, room);
        alice.move(planetCatalogue);
        assertTrue(planetCatalogue.charactersHere.contains(alice));
        assertEquals(alice.location, planetCatalogue);
    }

    @Test
    void moveCharacterGroup() {
        characterGroup.move(room);
        assertTrue(planetCatalogue.charactersHere.isEmpty());
        characterGroup.forEach(character -> assertEquals(character.location, room));
        characterGroup.forEach(character -> assertTrue(room.charactersHere.contains(character)));
    }

    @Test
    void testInteractionWithTableFromAnotherLocation() {
        room.thingsHere.add(table);
        assertThrows(ThingNotFoundInCurrentLocationException.class, () -> alice.interactWith(table));
    }

    @Test
    void testInteractionWithSofaFromAnotherLocation() {
        room.thingsHere.add(sofa);
        assertThrows(ThingNotFoundInCurrentLocationException.class, () -> alice.interactWith(sofa));
    }

    @Test
    void testInteractionWithAwardFromAnotherLocation() {
        room.thingsHere.add(award);
        assertThrows(ThingNotFoundInCurrentLocationException.class, () -> alice.interactWith(award));
    }

    @Test
    void testInteractionWithSofa() {
        planetCatalogue.thingsHere.add(sofa);
        lyosha.interactWith(sofa);
        assertEquals(lyosha.state, CharacterState.SITTING);
    }

    @Test
    void testInteractionWithMagratheanFromAnotherLocation() {
        assertThrows(CharacterNotFoundInCurrentLocationException.class, () -> lyosha.interactWith(magrathean, CharacterInteractionType.LOOK));
        assertEquals(CharacterState.IDLE, lyosha.state);
    }

    @Test
    void testInteractionWithMagrathean() {
        lyosha.move(room);
        lyosha.interactWith(magrathean, CharacterInteractionType.LOOK);
        assertEquals(CharacterState.LOOKING, lyosha.state);
    }

    @Test
    void testInteractionWithTable() {
        planetCatalogue.thingsHere.add(table);
        lyosha.interactWith(table);
        assertEquals(lyosha.state, CharacterState.TEA_DRINKING);
    }

    @Test
    void testInteractionWithAward() {
        planetCatalogue.thingsHere.add(award);
        lyosha.interactWith(award);
        assertEquals(lyosha.state, CharacterState.ADMIRING);
    }

    @Test
    void testInteractionWithThings() {
        planetCatalogue.thingsHere.add(sofa);
        planetCatalogue.thingsHere.add(table);
        planetCatalogue.thingsHere.add(award);
        lyosha.interactWith(sofa);
        assertEquals(lyosha.state, CharacterState.SITTING);
        lyosha.interactWith(table);
        assertEquals(lyosha.state, CharacterState.TEA_DRINKING);
        lyosha.interactWith(award);
        assertEquals(lyosha.state, CharacterState.ADMIRING);
    }
}

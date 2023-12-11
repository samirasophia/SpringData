package Asterixx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CharacterServiceTest {

    @Test
    void findAll(){
        CharacterRepository repo = mock(CharacterRepository.class);
        Mockito.when(repo.findAll()).thenReturn( List.of(
                new Character("455", "45678", "meow",88,"meowmeow"),
                 new Character("455", "45678", "meowmeowwwww",88,"meowmeow")));
        CharacterService service = new CharacterService(repo);
       List<Character> actual = service.findAll();
       List<Character> expected = List.of(
               new Character("455", "45678", "meow",88,"meowmeow"),
        new Character("455", "45678", "meowmeowwwww",88,"meowmeow")
       );
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void getCharbyId() {
        CharacterRepository repo = Mockito.mock(CharacterRepository.class);

        String id = "12";
        Character expected = new Character("12", "12", "meow", 2, "meow");

        Mockito.when(repo.findById(id)).thenReturn(Optional.of(expected));

        Optional<Character> actual = repo.findById(id);

        Assertions.assertEquals(Optional.of(expected), actual);
    }


    @Test
    public void addCharacter() {

        CharacterRepository repo = Mockito.mock(CharacterRepository.class);
        Character expected = new Character("12", "12", "meow", 2, "meow");

        CharacterService service = new CharacterService(repo);
        Mockito.when(repo.save(Mockito.any(Character.class))).thenReturn(expected);


        Character actual = service.add(expected);


        Mockito.verify(repo).save(Mockito.any(Character.class));
        assertEquals(expected, actual);
    }

    @Test
    public void deleteCharacter() {

        CharacterRepository repo = Mockito.mock(CharacterRepository.class);
        String id = "12";
        CharacterService service = new CharacterService(repo);
        List<Character> expected = List.of(
                new Character("455", "45678", "meow", 88, "meowmeow"),
                new Character("455", "45678", "meowmeowwwww", 88, "meowmeow"),
                new Character("12", "45678", "meowmeowwwww", 88, "meowmeow")
        );
        service.delete(id);
        Mockito.verify(repo).deleteById(id);
    }

    @Test
    public void updateCharacter() {

        CharacterRepository repo = Mockito.mock(CharacterRepository.class);

        Character given = new Character("12", "12", "meow", 2, "meow");
        Character expected = new Character("meow", "12", "meow", 2, "meow");

        CharacterService service = new CharacterService(repo);
        Mockito.when(repo.findAll()).thenReturn(Collections.singletonList(given));
        Mockito.when(repo.findById("meow")).thenReturn(Optional.of(expected));
        Character actual = service.updateCharacterId("12", "meow");
        Mockito.verify(repo).save(expected);

        service.updateCharacterId("12", "meow");
        Assertions.assertEquals(expected, actual);
    }
  @Test
          public void up(){
    List<Character> characters = new ArrayList<>();
    CharacterRepository repoMock = Mockito.mock(CharacterRepository.class);
Mockito.when(repoMock.findAll()).thenReturn(characters);


      Character given = new Character("12", "12", "meow", 2, "meow");
given.withId("12");
characters.add(given);


   CharacterService service = new CharacterService(repoMock);
    Character updatedCharacter = service.updateCharacterId("12", "meow");

// Verify that character was updated
Assertions.assertEquals("meow", updatedCharacter.id());

// Verify that the repository was called correctly
Mockito.verify(repoMock).findById("meow");
    }}

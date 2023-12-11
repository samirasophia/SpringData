package Asterixx;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
public class CharacterControllerAlt {

    private final CharacterRepository charRepo;


    public CharacterControllerAlt(CharacterRepository charRepo) {
        this.charRepo = charRepo;
    }
/*
    @PostMapping ("/characters")
    public ResponseEntity createCharacter(@RequestBody java.lang.Character character){
        java.lang.Character newChar = CharacterService.add(character);
        return ResponseEntity.ok(newChar);
    } */
    @GetMapping
    public List<Character> getAllProducts() {
        List<Character> allAsterix = charRepo.findAll();

        //...

        return allAsterix;
    }

}

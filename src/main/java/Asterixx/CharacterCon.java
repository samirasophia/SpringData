package Asterixx;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Service
@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterCon {


    private final CharacterService service;

    /*    public ProductController(ProductService service) {
            this.service = service;
        }
    */

    @PostMapping
    public Character addCharacter(@RequestBody Character character) {
        return service.add(character);
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {
        service.delete(id);
    }
@PutMapping("{id}")
    public Character updateCharacter(@PathVariable String id, @RequestParam String newId){
       return service.updateCharacterId(id, newId);

}

}




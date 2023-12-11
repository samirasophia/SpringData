package Asterixx;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Service
@RestController
@RequestMapping("/api/products")
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
@PutMapping("/put/{id}")
    public void updateCharacter(@PathVariable String id, String id2){
        service.updateCharacterId(id, id2);
}
}




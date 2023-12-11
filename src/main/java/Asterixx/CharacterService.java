package Asterixx;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository repo;

    public Character add(Character character) {

        return repo.save(character);
        //Nicht mal die Hilfe Bastians bringt meinen Code zum funktionieren.
    }


    /*   public ProductService(ProductRepository repo) {
           this.repo = repo;
       }
   */
    public Character updateCharacterId(String oldId, String newId) {
        for (Character character : repo.findAll()) {
            if (character.id().equalsIgnoreCase(oldId)) {
                repo.save(character.withId(newId));
                break;
            }
            repo.deleteById(oldId);

        }
        return (Character) repo.findById(newId).orElse(null);
    }

    public List<Character> findAll() {
        return repo.findAll();
    }

    public CharacterRepository delete(String id) {
        repo.deleteById(id);
        return repo;
    }

    public Character findById(String id) {
        return (Character) repo.findById(id).orElse(null);
    }

}

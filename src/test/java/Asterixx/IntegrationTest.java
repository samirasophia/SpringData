package Asterixx;

import Asterixx.Character;
import Asterixx.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private CharacterRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    void returnAll() throws Exception {
        //given

        repo.save(new Character("meow", "meoww", "meowzaza", 88, "meowzies"));
        repo.save(new Character("meow2", "meoww2", "meowzaza2", 882, "meowzies2"));
        //when
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/characters")

                )

                //then
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                )
                .andExpect(
                        MockMvcResultMatchers.content().json("""

                                [
                                {
                                "id": "meow",
                                "id2": "meoww",
                                "name": "meowzaza",
                                "age": 88,
                                "occupation": "meowzies"
                                },
                                {
                                "id": "meow2",
                                "id2": "meoww2",
                                "name": "meowzaza2",
                                "age": 882,
                                "occupation": "meowzies2"
                                }

                                ]



                                """)
                )
        ;
    }

    @Test
    @DirtiesContext
    void putMethode() throws Exception {

        //given

        //when
        mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/characters/meow?newId=rawr")
                                .content("""
                                                                        {
                                                                        "id": "meow",
                                        "id2": "meoww",
                                        "name": "meowzaza",
                                        "age": 88,
                                        "occupation": "meowzies"
                                                                        
                                                                        
                                                                        }
                                                                        
                                                                        """)
                                .contentType(MediaType.APPLICATION_JSON)
                )

                //then
                .andExpect((MockMvcResultMatchers.status().isOk()))
                .andExpect(MockMvcResultMatchers.content().json("""
                      [  {
                                                        "id": "rawr",
                        "id2": "meoww",
                        "name": "meowzaza",
                        "age": 88,
                        "occupation": "meowzies"
                                                        
                                                        
                                                        }

]
                        """))
        ;

        List<Character> actual = repo.findAll();
        List<Character> expected = List.of(
                new Character("rawr", "meoww", "meowzaza", 88, "meowzies")
        );
        Assertions.assertEquals(actual, expected);
    }
    @Test
    @DirtiesContext
    void delete() throws Exception {

        //given

        //when
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/characters/meow")
                                .content("""
                                                                        {
                                                                        "id": "meow",
                                        "id2": "meoww",
                                        "name": "meowzaza",
                                        "age": 88,
                                        "occupation": "meowzies"
                                                                        
                                                                        
                                                                        }
                                                                        
                                                                        """)
                                .contentType(MediaType.APPLICATION_JSON)
                )

                //then
                .andExpect((MockMvcResultMatchers.status().isOk()))
                .andExpect(MockMvcResultMatchers.content().json("[]"));
        ;

        List<Character> actual = repo.findAll();
        List<Character> expected = List.of(
        );
        Assertions.assertEquals(actual, expected);
    }
}

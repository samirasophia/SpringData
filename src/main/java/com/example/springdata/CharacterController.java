package com.example.springdata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
public class CharacterController {

    private final CharacterRepository charRepo;


    public CharacterController(CharacterRepository charRepo) {
        this.charRepo = charRepo;
    }

    @GetMapping
    public List<Characters> getAllProducts() {
        List<Characters> allAsterix = charRepo.findAll();

        //...

        return allAsterix;
    }
}

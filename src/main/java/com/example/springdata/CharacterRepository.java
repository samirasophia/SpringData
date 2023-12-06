package com.example.springdata;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends MongoRepository<Characters, ObjectId> {
//Anstatt dumme Asterix Namen, bleibe ich bei meinen Produkten
}
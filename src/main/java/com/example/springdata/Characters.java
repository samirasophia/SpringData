package com.example.springdata;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Asterix")
public record Characters(ObjectId id, String id2, String name, int age, String occupation) {


}

package Asterixx;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Asterix")
@With
public record Character(String id, String id2, String name, int age, String occupation) {


}

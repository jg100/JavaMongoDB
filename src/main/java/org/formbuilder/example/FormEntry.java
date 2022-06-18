package org.formbuilder.example;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.ArrayList;

//Doc represents the collections in the MongoDB database

@Document(collation = "Forms")
@AllArgsConstructor //L
@NoArgsConstructor//L
@Getter
@Setter
public class FormEntry {
    @Id
    private final Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String refSource;
    private String insurance;
    private ArrayList<String> callNotes = new ArrayList<>();


}

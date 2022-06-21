package org.formbuilder.example;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

//Doc represents the collections in the MongoDB database

@Document(collection = "forms")
@Data
public class Forms {

    @Id
    private String id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String refSource;
    private String insurance;
    private ArrayList<String> callNotes = new ArrayList<>();

    public Forms(String id, String fullName, String phoneNumber, String email, String refSource) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.refSource = refSource;
        this.insurance = refSource;
    }
}

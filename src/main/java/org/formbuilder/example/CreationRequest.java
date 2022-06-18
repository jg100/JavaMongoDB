package org.formbuilder.example;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CreationRequest
{
    private String fullName;
    private String phoneNumber;
    private String email;
    private String refSource;
    private String insurance;
    private ArrayList<String> callNotes = new ArrayList<>();

}

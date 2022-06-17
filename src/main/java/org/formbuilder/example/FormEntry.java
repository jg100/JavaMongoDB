package org.formbuilder.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document(collation = "Forms")
public class FormEntry {
    private final Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String refSource;
    private String insurance;

    private ArrayList<String> callNotes = new ArrayList<>();

    public FormEntry(Long id, String fullName, String phoneNumber, String email, String refSource, String insurance) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.refSource = refSource;
        this.insurance = insurance;

    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getRefSource() {
        return refSource;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRefSource(String refSource) {
        this.refSource = refSource;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public ArrayList<String> getCallNotes() {
        return callNotes;
    }
}

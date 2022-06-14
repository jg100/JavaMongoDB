package org.formbuilder.example;

import java.util.ArrayList;

public class DataEntry {
    private String firstName;
    private String lastName;
    private String[] status;

    private ArrayList<String> notes;
    private int id;

    public DataEntry(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = new ArrayList<>();
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public boolean addNote(String note) {
        return notes.add(note);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String[] getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}

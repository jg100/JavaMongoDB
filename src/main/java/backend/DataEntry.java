package backend;

public class DataEntry {
    private String firstName;
    private String lastName;
    private String callNotes;
    private String[] status;
    private int id;

    public DataEntry(String firstName, String lastName, String callNotes, String[] status, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.callNotes = callNotes;
        this.status = status;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCallNotes() {
        return callNotes;
    }

    public String[] getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}

package backend;

import static com.mongodb.client.model.Filters.eq;

import java.io.File;
import java.util.Scanner;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoActions {
    private MongoClient mc;
    private MongoDatabase mdb;


    public MongoActions(String uri, String dbName) {
        this.mc = MongoClients.create(uri);
        this.mdb = this.mc.getDatabase(dbName);
    }

    public boolean addEntry(DataEntry de, String collectionName) {
        try {
            MongoCollection<Document> collection = this.mdb.getCollection(collectionName);
            System.out.println("Connected to collection... addEntry() method");

            Document doc = new Document("First Name", de.getFirstName())
                    .append("Last Name", de.getLastName())
                    .append("Call notes", de.getCallNotes());


            collection.insertOne(doc);
            System.out.println("Document has been inserted to " + collectionName);
            return true;
        }catch(Exception e) {
            System.out.println("**** Error ******:");
            System.out.println(e);
            return false;
        }

    }



}

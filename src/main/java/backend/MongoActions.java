package backend;

import static com.mongodb.client.model.Filters.eq;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoActions {
    private MongoClient mc;
    private MongoDatabase mdb;

    private MongoCollection<Document> collection;


    public MongoActions(String uri, String dbName, String collectionName) {
        this.mc = MongoClients.create(uri);
        this.mdb = this.mc.getDatabase(dbName);
        this.collection = this.mdb.getCollection(collectionName);
    }

    public boolean addEntry(DataEntry de) {
        try {

            //Adds an entry by passing in a DataEntry object. May try to refactor to make code less coupled
            //Maybe just pass in the values.
            Document doc = new Document("First Name", de.getFirstName())
                    .append("Last Name", de.getLastName())
                    .append("Call notes", de.getCallNotes());

            this.collection.insertOne(doc);
            System.out.println("Document has been inserted to " + this.collection.toString());
            return true;
        }catch(Exception e) {
            System.out.println("**** Error ******:");
            System.out.println(e);
            return false;
        }
    }

    /**
    public boolean findEntry(String name) {
        try {

        } catch(Exception ex) {
            System.out.println("**** Error *****\n" + ex);
            return false;
        }

    }
     */

    public List<Document> getAllEntries() {
        List<Document> list = new ArrayList<Document>();
        FindIterable<Document> findIter = this.collection.find();
        Iterator it = findIter.iterator();

        while(it.hasNext()) {
            list.add((Document) it.next());
        }
        return list;
    }





}

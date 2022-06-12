package backend;

import static com.mongodb.client.model.Filters.eq;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mongodb.client.*;
import org.bson.Document;

import javax.print.Doc;

public class MongoActions {
    private MongoClient mc;
    private MongoDatabase mdb;

    private MongoCollection<Document> collection;


    public MongoActions(String uri, String dbName, String collectionName) {
        this.mc = MongoClients.create(uri);
        this.mdb = this.mc.getDatabase(dbName);
        this.collection = this.mdb.getCollection(collectionName);

    }

    /**
     * Adding and modifying entries
     */

    public boolean addEntry(DataEntry de) {
        try {

            //Adds an entry by passing in a DataEntry object. May try to refactor to make code less coupled
            //Maybe just pass in the values.
            Document doc = new Document("First Name", de.getFirstName())
                    .append("Last Name", de.getLastName())
                    .append("Call notes", de.getNotes());

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
     * Function to add a note to a specific entry in a collection
     * @return
     */
    public boolean addNote(String note) {

        //get collection

        //get document

        //update document

        //return t/f

    }

    /**
     * Retriving entries
     */


    public Document getEntry(String name) {

        List<Document> entries = this.getAllEntries();

        for(Document doc : entries) {
            if(doc.containsValue(name)) {
                return doc;
            }
        }

    return null;
    }


    public List<Document> getAllEntries() {
        List<Document> list = new ArrayList<>();
        //Returns a cursor for the collection
        FindIterable<Document> findIter = this.collection.find();

        //Turn cursor into iterable and iterate through ea val.
        Iterator it = findIter.iterator();
        while(it.hasNext()) {
            //Add value to final list that is returned
            list.add((Document) it.next());
        }
        return list;
    }


}

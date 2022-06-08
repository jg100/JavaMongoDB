import static com.mongodb.client.model.Filters.eq;

import java.io.File;
import java.util.Scanner;

import backend.DataEntry;
import backend.MongoActions;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
public class Driver {
    public static void main(String[] args)  {
        String uri = "";

        try {
            Scanner sc = new Scanner(new File("/Users/joel/Downloads/JavaMongoDB/src/main/resources/cred.txt"));
            uri = sc.nextLine();
        } catch(Exception ex) {
            System.out.println(ex);
        }
        System.out.println("URI: " + uri);

        MongoActions mongo = new MongoActions(uri, "FormBuilder", "Forms");
        //DataEntry de = new DataEntry("Joel", "Giannelli","Call went well");
        //mongo.addEntry(de);

        System.out.println(mongo.getAllEntries());

        System.out.println(mongo.getEntry("Joel"));

    }
}
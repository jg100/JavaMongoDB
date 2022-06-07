import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class Driver {
    public static void main(String[] args)  {
        String uri = "";
        try {
            Scanner sc = new Scanner(new File("cred.txt"));
            uri = sc.nextLine();
        } catch(Exception ex) {
            System.out.println(ex);
        }

        // Replace the uri string with your MongoDB deployment's connection string
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Forms");
            //MongoCollection<Document> collection = database.getCollection("movies");

            //Document doc = collection.find(eq("title", "Back to the Future")).first();
            //System.out.println(doc.toJson());
        }
    }
}
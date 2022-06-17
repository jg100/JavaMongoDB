package org.formbuilder.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.formbuilder.example")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getProperty("mongo.database");
    }

    /**
     * public com.mongodb.client.MongoClient mongoClient()
     * Return the MongoClient instance to connect to. Annotate with Bean in case you want to expose a MongoClient instance to the ApplicationContext.
     * Override MongoConfigurationSupport.mongoClientSettings() to configure connection details.
     * @return MongoClient type from the mongo driver
     */
    @Override
    public MongoClient mongoClient() {
        ConnectionString cstring = new ConnectionString(env.getProperty("mongo.connection.string"));

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(cstring).build();






    }


}

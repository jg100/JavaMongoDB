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

import java.util.Collection;
import java.util.Collections;

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

        return MongoClients.create(mongoClientSettings);
    }

    /**
     * Returns the base packages to scan for MongoDB mapped entities at startup. Will return the package name of the
     * configuration class' (the concrete class, not this one here) by default. So if you have a com.acme.AppConfig
     * extending MongoConfigurationSupport
     * the base package will be considered com.acme unless the method is overridden to implement alternate behavior.
     * @return
     */
    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("org.formbuilder.example.Driver");
    }

}

package org.formbuilder.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositories are data access layers for databses.
 * Provides a way to interact with databses and complete certain tasks on it.
 *
 * Link between the model and the database. Actual CRUD operations occur here.
 */

@Repository
public interface FormRepo extends MongoRepository<Forms, String> {

    @Query("{fullName:'?0'}")
    Forms findByName(String name);


}

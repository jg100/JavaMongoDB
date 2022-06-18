package org.formbuilder.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositories are data access layers for databses.
 * Provides a way to interact with databses and complete certain tasks on it.
 */

@Repository
public interface FormRepo extends MongoRepository<FormEntry, String> {


}

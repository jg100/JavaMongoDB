package org.formbuilder.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FormRepo extends MongoRepository<FormEntry, String> {


}

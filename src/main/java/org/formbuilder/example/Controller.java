package org.formbuilder.example;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * CRUD API
 * Create
 * Update
 * Delete
 */

@RestController
@RequiredArgsConstructor
public class Controller {

    @Autowired
    FormRepo formRepo;

    @PostMapping("/forms")
    public boolean makeEntry() {
        formRepo.save( new Forms(
                "123eww78","MILO BORWN","4153164897","jgiannelli13@gmail.com","n/a"));
        return true;
    }

    //Find by name
    @GetMapping("/find")
    public Forms findByName(@RequestParam(value = "fullName") String fullName) {
        return formRepo.findItemByName(fullName);
    }

}


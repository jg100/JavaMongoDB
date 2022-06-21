package org.formbuilder.example;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/test")
    public String test() {
        return "API UP AND RUNNING";
    }


    @PostMapping("/forms")
    public boolean makeEntry() {
        formRepo.save( new Forms(
                "123eww78","MILO BORWN","4153164897","jgiannelli13@gmail.com","n/a"));
        return true;
    }

    //Find by name

    @GetMapping("/all")
    public List<Forms> findAll() {
        System.out.println("\ngetAll called\n");
        return formRepo.findAll();
    }

    @GetMapping("/find")
    public Forms findByName(@RequestParam(name = "name")String name) {
        return formRepo.findByName(name);
    }

}


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

    @PostMapping("/create")
    public String create(
            @RequestParam(name = "id") String id,
            @RequestParam(name = "fullName") String fullName,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "refSource") String refSource
    ) {

        try {
            formRepo.save(new Forms(id ,fullName ,phone ,email ,refSource));
            return "Successfully added to MongoDB";
        } catch(Exception ex) {
            return "An error has occured:\n" + ex;
        }
    }

    //update


    //delete by name
    @DeleteMapping("/deletebyname")
    public boolean delete(@RequestParam(name = "fullName") String fullName) {
        formRepo.delete(formRepo.findByName(fullName));
        return false;
    }


    @GetMapping("/test")
    public String test() {
        return "API UP AND RUNNING";
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


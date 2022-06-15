package org.formbuilder.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {
    private static final String temp = "Hello! %s";
    private final AtomicLong counter = new AtomicLong();

    //HTTP GET req mapped to function same as @RequestMapping(method=GET)
    @GetMapping("/form")
    public FormEntry formentry(@RequestParam(value = "name", defaultValue = "Joe") String name,
                               @RequestParam(value = "phone", defaultValue = "000") String phone,
                               @RequestParam(value = "email", defaultValue = "0@gmail") String email,
                               @RequestParam(value = "refSource", defaultValue = "None") String refSource,
                               @RequestParam(value = "insurance", defaultValue = "UBH") String insurance) {

        return new FormEntry(counter.incrementAndGet(), name, phone, email, refSource, insurance);
    }

    @PostMapping("/new")
    public boolean addEntry(@RequestParam(value = "name", defaultValue = "Joe") String name,
                            @RequestParam(value = "phone", defaultValue = "000") String phone,
                            @RequestParam(value = "email", defaultValue = "0@gmail") String email,
                            @RequestParam(value = "refSource", defaultValue = "None") String refSource,
                            @RequestParam(value = "insurance", defaultValue = "UBH") String insurance) {

        return true;
    }





}

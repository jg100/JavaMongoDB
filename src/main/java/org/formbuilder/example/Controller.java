package org.formbuilder.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

public class Controller {
    private static final String temp = "Hello!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/form")
    public FormEntry formentry(@RequestParam()) {


    }




}

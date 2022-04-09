package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//In Spring's approach to building RESTful web services, HTTP requests are handled by a controller
@RestController // it marks the class as a controller where every method reuturns a domain object of a view
public class GreetingController {
    //This class handles GET requests for /greeting by returning a new instance of the Greeting class
    private static final String template = "Hello,%s";
    private final AtomicLong counter = new AtomicLong();

    //The @GetMapping ensures that HTTP GET request /greeting are correctly mapped to the greeing() method
    @GetMapping("/greeting")
    //@RequestParam binds the value of the query string parameter name into the name parameter of the method
    //If the name parameter is absent, a default value is used
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Motherfucker") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

package hello.controller;

import hello.Greeting;
import hello.models.User;
import hello.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue = "World") String name) throws SQLException {

        User user = new User("Гога", 12);
        UserService us = new UserService();
        us.addUser(user);
        return new Greeting(counter.incrementAndGet(), us.getAllUsers().toString());
    }

    @RequestMapping("/stringing")
    public String stringing(){
        return "Greeting(counter.incrementAndGet(), String.format(template, name))";
    }

    @RequestMapping("/script")
    public void script(){
        UserService us = new UserService();
        us.script();
    }
}

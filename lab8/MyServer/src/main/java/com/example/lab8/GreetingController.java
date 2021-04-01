package com.example.lab8;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

@RestController
public class GreetingController extends HttpServlet {
    private static final String template = "Welcome, %s!";

    @GetMapping("/greeting")
    public User getUser(@RequestParam(value = "name", defaultValue = "World") User user) {
        System.out.println("Запрос от пользователя " + user.name);
        return new User( String.format(template, user));
    }

    @RequestMapping(path="/greeting/{userName}",method = RequestMethod.GET)
    public User greeting(@PathVariable("userName") String user) {
        System.out.println("Запрос от пользователя " + user);
        return new User("Welcome, " + user);
    }
}
package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    //@RequestMapping(value="/user", method= RequestMethod.GET)
    @GetMapping("/user")
    public User user()
    {
        User user = new User();
        user.setId("1");
        user.setName("Raj");
        user.setEmailId("tipu@gmail.com");
        return user;
    }
    @GetMapping("/{id}/{id2}")
    public String PathVariable(@PathVariable String id, @PathVariable("id2") String name)
    {
        return "The path Variable is: "+id+" "+name;
    }

    @GetMapping("/requestParam")
    public String requestParamss(@RequestParam String name, @RequestParam(name="email",required = false,defaultValue = "") String emailId)
    {
        return "The request param is: "+name+" email: "+emailId;
    }
}

package com.couchbase.controller;

import com.couchbase.entity.User;
import com.couchbase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User create(@RequestBody User user) {
        var a = "raja";
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable String id) {
        return userService.get(id);
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PutMapping("/")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/nameAndAge")
    public User findByNameAndAge(@RequestParam String name, @RequestParam Integer age) {
        return userService.findByNameAndAge(name, age);
    }

}

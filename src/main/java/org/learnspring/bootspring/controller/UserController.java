package org.learnspring.bootspring.controller;

import org.learnspring.bootspring.entity.User;
import org.learnspring.bootspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //if Content Type is application/json or application/xml use @RequestBody annotation, if it is application/x-www-form-urlencoded use @ModelAttribute
    @PostMapping("/post")
    public User post(@RequestBody User user){   //@RequestBody   @ModelAttribute @RequestParam
        System.out.println(user.getUsername());
        userService.createUser(user);
        return user;
    }


}
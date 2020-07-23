package org.learnspring.bootspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.learnspring.bootspring.model.entities.Actor;
import org.learnspring.bootspring.model.manager.ActorRepository;

import java.util.List;

@RestController
public class HomeController {

@Autowired(required = true)
private ActorRepository actorRepository;
    
@GetMapping("/")
public String Home(){
    return "Home Page";
}

@GetMapping("/actor")
public String Actor(){
    return actorRepository.getAll().getFirstName();
}


}
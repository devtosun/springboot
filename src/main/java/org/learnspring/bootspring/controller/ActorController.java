package org.learnspring.bootspring.controller;

import org.learnspring.bootspring.entity.Actor;
import org.learnspring.bootspring.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired()
    private ActorService actorService;

    @GetMapping("/actor/all")
    @Cacheable("getAllActor")
    public Iterable<Actor> getAllActor() {
        return actorService.findAll();
    }

    @GetMapping("/actor/{id}")
    @Cacheable("findActorById")
    @CrossOrigin(origins = "*", allowedHeaders = "*") // CORS policy > Access-Control-Allow-Origin
    public Actor findActorById(@PathVariable("id") Long id) {
        Actor actor = actorService.findById(id);
        if (actor == null)
            throw new IllegalArgumentException("I can not find a actor with id : " + id);
        return actor;
    }

    @PostMapping("/saveactor")
    public Actor saveActor(@RequestBody Actor actor) {
        System.out.println(actor.getFirstName());
        if (actor != null)
            throw new IllegalArgumentException("Actor adi : " + actor.getFirstName()); // buraya ayar cekiceksin
        return actor;
    }

}

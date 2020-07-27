package org.learnspring.bootspring.controller;

import org.learnspring.bootspring.entities.Actor;
import org.learnspring.bootspring.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired()
    private ActorService actorService;

    @GetMapping("/actor/all")
    public Iterable<Actor> getAllActor() {
        return actorService.findAll();
    }

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable("id") Long id) {
        Actor actor = actorService.findById(id);
        if (actor == null)
            throw new IllegalArgumentException("I can not find a actor with id : " + id);
        return actor;
    }

    //@PostMapping("/saveactor")
    //public Actor saveActor(@RequestBody Actor actor) {
    //    if (actor != null)
    //        throw new IllegalArgumentException("Actor adi : " + actor.getFirstName()); // buraya ayar cekiceksin
    //    return null;
    //}

}

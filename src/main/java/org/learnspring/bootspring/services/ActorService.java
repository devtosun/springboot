package org.learnspring.bootspring.services;

import org.learnspring.bootspring.entities.Actor;
import org.learnspring.bootspring.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Iterable<Actor> findAll() {
        return actorRepository.findAll();
    }

    public Actor findById(Long id) {
        try {
            return actorRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }

    }

}
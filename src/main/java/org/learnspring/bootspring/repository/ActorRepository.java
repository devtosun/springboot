package org.learnspring.bootspring.repository;

import org.learnspring.bootspring.entities.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    
}
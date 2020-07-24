package org.learnspring.bootspring.model.manager;

import java.util.List;
import org.learnspring.bootspring.model.entities.Actor;
import org.springframework.stereotype.Service;

@Service
public interface ActorRepository {
    
    List<Actor> getAll();
    Actor getByName(int id);
}
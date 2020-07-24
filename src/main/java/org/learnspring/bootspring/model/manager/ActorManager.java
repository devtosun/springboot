package org.learnspring.bootspring.model.manager;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.learnspring.bootspring.model.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActorManager implements ActorRepository {
    
    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public List<Actor> getAll(){
        List<Actor> actors = getSession().createQuery("from Actor", Actor.class).getResultList();
        return actors;
    }

    public Actor getByName(int id){
        return  (Actor)getSession().get(Actor.class, id);
    }

}
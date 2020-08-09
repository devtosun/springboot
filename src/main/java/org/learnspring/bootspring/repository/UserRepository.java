package org.learnspring.bootspring.repository;

import org.learnspring.bootspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
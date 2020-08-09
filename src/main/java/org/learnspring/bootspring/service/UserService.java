package org.learnspring.bootspring.service;

import org.learnspring.bootspring.entity.User;
import org.learnspring.bootspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        //if (userRepository.existsById(user.getId())) {
        //    return userRepository.save(user);
        //} else {
        //    return null;
        //}
        return userRepository.save(user);
    }
}
package com.test.testhack.services;

import com.test.testhack.models.UserModel;
import com.test.testhack.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepo = userRepository;
    }

    public void addUser(UserModel user){
        userRepo.save(user);
    }

    public UserModel getUserById(Long user_id){
        return userRepo.getReferenceById(user_id);
    }
}

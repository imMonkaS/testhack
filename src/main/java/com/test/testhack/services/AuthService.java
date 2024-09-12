package com.test.testhack.services;

import com.test.testhack.exceptions.AlreadyExistException;
import com.test.testhack.models.UserModel;
import com.test.testhack.repositories.UserRepo;
import com.test.testhack.schemas.user.CreateUserSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetails user = repo.findByLogin(username);
        return user;
    }

    public void signUp(CreateUserSchema data) throws AlreadyExistException {
        if (repo.findByLogin(data.login) != null) {
            throw new AlreadyExistException ("Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password);
        UserModel newUser = new UserModel(data.login, encryptedPassword, data.email, data.firstName, data.lastName, data.role);
        repo.save(newUser);
    }
}

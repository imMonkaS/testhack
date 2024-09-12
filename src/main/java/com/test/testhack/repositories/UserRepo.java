package com.test.testhack.repositories;

import com.test.testhack.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.core.userdetails.UserDetails;


@RepositoryRestResource
public interface UserRepo extends JpaRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel> {
    UserDetails findByLogin(String login);
}

package com.test.testhack.repositories;

import com.test.testhack.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface UserRepo extends JpaRepository<UserModel, Long> {

}

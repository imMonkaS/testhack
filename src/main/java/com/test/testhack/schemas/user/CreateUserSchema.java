package com.test.testhack.schemas.user;

import com.test.testhack.enums.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;


@Getter
@Setter
public class CreateUserSchema {

    public String login;
    public String password;
    public String email;
    public UserRole role = UserRole.USER;

    public String firstName;

    public String lastName;
}

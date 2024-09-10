package com.test.testhack.schemas.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class GetUsersSchema {

    @Nullable
    public String firstName;

    @Nullable
    public String lastName;

    public List<String> getFields(){
        return Arrays.asList("firstName", "lastName");
    }

    public List<String> getValues(){
        return Arrays.asList(firstName, lastName);
    }
}

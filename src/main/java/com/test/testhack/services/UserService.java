package com.test.testhack.services;

import com.test.testhack.exceptions.NotFoundException;
import com.test.testhack.models.OrgModel;
import com.test.testhack.models.UserModel;
import com.test.testhack.repositories.OrgRepo;
import com.test.testhack.repositories.UserRepo;
import com.test.testhack.schemas.user.GetUsersSchema;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final OrgRepo orgRepo;

    @Autowired
    public UserService(UserRepo userRepository, OrgRepo orgRepository) {
        this.userRepo = userRepository;
        this.orgRepo = orgRepository;
    }

    public void addUser(UserModel user){
        userRepo.save(user);
    }

    public UserModel getUserById(Long user_id){
        return userRepo.findById(user_id).orElseThrow(() -> new NotFoundException(user_id, "User"));
    }

    public List<UserModel> getUsers(GetUsersSchema userData){
        Specification<UserModel> spec = Specification.where(null);

        List<String> vals = userData.getValues();
        List<String> fields = userData.getFields();

        for (int i = 0; i < fields.size(); i++){
            String field_name = fields.get(i);
            String val = vals.get(i);
            if (vals.get(i) != null){
                spec = spec.and(((root, query, cb) -> cb.equal(root.get(field_name), val)));
            }
        }

//        Этот способ лучше, тк сработает для разнородных данных
//        if (userData.firstName != null){
//            spec = spec.and(((root, query, cb) -> cb.equal(root.get("firstName"), userData.firstName)));
//        }
//
//        if (userData.lastName != null){
//            spec = spec.and(((root, query, cb) -> cb.equal(root.get("lastName"), userData.lastName)));
//        }

        return this.userRepo.findAll(spec);
    }

    public List<UserModel> getAll(){
        return this.userRepo.findAll();
    }

    public void deleteById(Long user_id){
        this.userRepo.deleteById(user_id);
    }

    public List<OrgModel> getUserOrgs(Long user_id){
        return this.orgRepo.findAllByUserId(user_id);
    }

}

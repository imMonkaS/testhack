package com.test.testhack.services;

import com.test.testhack.exceptions.NotFoundException;
import com.test.testhack.models.OrgModel;
import com.test.testhack.repositories.OrgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {
    private final OrgRepo orgRepo;

    @Autowired
    public OrgService(OrgRepo orgRepo) {
        this.orgRepo = orgRepo;
    }

    public void addOrganization(OrgModel org){
        orgRepo.save(org);
    }

    public OrgModel getOrgById(Long org_id){
        return orgRepo.findById(org_id).orElseThrow(() -> new NotFoundException(org_id, "Organization"));
    }

//    public void addMember(Long user_id){
//        OrgMembersModel item = new OrgMembersModel();
//        item.
//        orgRepo.
//    }
}

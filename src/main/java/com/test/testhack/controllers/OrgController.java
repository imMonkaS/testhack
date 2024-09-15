package com.test.testhack.controllers;

import com.test.testhack.models.OrgModel;
import com.test.testhack.models.UserModel;
import com.test.testhack.schemas.orgs.CreateOrgSchema;
import com.test.testhack.services.OrgService;
import com.test.testhack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/org")
public class OrgController {
    private final OrgService orgService;
    private final UserService userService;

    @Autowired
    public OrgController(OrgService orgService, UserService userService) {
        this.orgService = orgService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public OrgModel getOrgById(@PathVariable Long id){
        return orgService.getOrgById(id);
    }

    @PostMapping("/add")
    public String addOrg(@RequestBody CreateOrgSchema org){
        UserModel user = userService.getUserById(org.owner_id);
        OrgModel orgModel = new OrgModel(user, org.name);
        orgService.addOrganization(orgModel);
        return "Success";
    }
}

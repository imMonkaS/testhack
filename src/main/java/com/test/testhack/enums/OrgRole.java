package com.test.testhack.enums;

public enum OrgRole {
    OWNER("owner"),
    ADMIN("admin"),
    MEMBER("member");

    private String org_role;

    OrgRole(String role) {
        this.org_role = role;
    }

    public String getValue() {
        return org_role;
    }
}

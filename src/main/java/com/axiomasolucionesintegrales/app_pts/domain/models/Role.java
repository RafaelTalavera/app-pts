package com.axiomasolucionesintegrales.app_pts.domain.models;


import java.util.Arrays;
import java.util.List;

public enum Role {

    WORKER(Arrays.asList(Permission.SAVE_ONE_ITEMS, Permission.READ_ALL_ITEMS)),
    SUPERVISOR(Arrays.asList(Permission.SAVE_ONE_ITEMS, Permission.READ_ALL_ITEMS));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
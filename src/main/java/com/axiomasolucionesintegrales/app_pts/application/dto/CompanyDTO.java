package com.axiomasolucionesintegrales.app_pts.application.dto;

import com.axiomasolucionesintegrales.app_pts.domain.models.User;
import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermit;


import java.util.List;


public class CompanyDTO {
    private Long id;
    private String name;
    private List<User> users;
    private List<WorkPermit> workPermits;

    public CompanyDTO() {
    }

    public CompanyDTO(Long id, String name, List<User> users, List<WorkPermit> workPermits) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.workPermits = workPermits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<WorkPermit> getWorkPermits() {
        return workPermits;
    }

    public void setWorkPermits(List<WorkPermit> workPermits) {
        this.workPermits = workPermits;
    }
}

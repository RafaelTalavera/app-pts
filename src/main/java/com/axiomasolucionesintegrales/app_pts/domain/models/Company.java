package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;


import java.util.List;


@Table(name= "companies")
@Entity
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkPermit> workPermits;

    public Company() {
    }

    public Company(Long id, String name, List<User> users, List<WorkPermit> workPermits) {
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

package com.axiomasolucionesintegrales.app_pts.application.dto;


import com.axiomasolucionesintegrales.app_pts.domain.models.AuditLog;
import com.axiomasolucionesintegrales.app_pts.domain.models.Company;
import com.axiomasolucionesintegrales.app_pts.domain.models.Role;


import java.util.List;

public class UserDTO {

    private Long id;

    private String name;

    private String lastname;

    private String job;

    private String password;

    private String signature;

    private String username;

    private String phone;

    private Role role;

    private Company company;

    private List<AuditLog> auditLogs;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String lastname, String job, String password, String signature, String username, String phone, Role role, Company company, List<AuditLog> auditLogs) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.job = job;
        this.password = password;
        this.signature = signature;
        this.username = username;
        this.phone = phone;
        this.role = role;
        this.company = company;
        this.auditLogs = auditLogs;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<AuditLog> getAuditLogs() {
        return auditLogs;
    }

    public void setAuditLogs(List<AuditLog> auditLogs) {
        this.auditLogs = auditLogs;
    }
}


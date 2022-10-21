package com.example.yxiriatechnicaltest.infra.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public UserEntity() {
    }

    public UserEntity(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    private String firstname;

    private String lastname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

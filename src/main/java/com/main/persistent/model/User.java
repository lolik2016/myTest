package com.main.persistent.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//http://www.berdaflex.com/ru/java/articles/using_hibernate_java_persistence/ar01s02.html

//http://devcolibri.com/1191
//http://dev-blogs.com/simple-spring-application-using-autowired-annotation/

@Entity
@Table(name="t_user")
public class User {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    public User() {
    }

    public User(Long id, String userName, String name, String surname) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

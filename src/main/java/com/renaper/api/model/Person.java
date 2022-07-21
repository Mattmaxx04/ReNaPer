package com.renaper.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String name;
    @Column(nullable = false, updatable = false)
    private String lastname;
    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birth_date;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false, updatable = false)
    private String dni;

    public Person() {
    }

    public Person(String name, String lastname, Date birth_date, String sex, String dni) {
        this.name = name;
        this.lastname = lastname;
        this.birth_date = birth_date;
        this.sex = sex;
        this.dni = dni;
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

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birth_date=" + birth_date +
                ", sex='" + sex + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}

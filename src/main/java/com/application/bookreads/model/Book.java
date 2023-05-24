package com.application.bookreads.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    public Long id;

    @NonNull
    public String name;

    @NonNull
    public Date dateOfRelease;

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(@NonNull Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}

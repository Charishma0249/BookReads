package com.application.bookreads.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

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
}

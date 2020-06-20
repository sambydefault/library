package com.boot.librarymanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String name;
    public String author;
    public int rate;
    @ManyToOne
    public Library library;
}

package com.boot.librarymanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String sectionName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "library")
    public List<Book> books;
}

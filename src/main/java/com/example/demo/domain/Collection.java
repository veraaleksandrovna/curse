package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "collection")
public class Collection {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name = "year")
private int year;
@Column(name = "name")
private String name;
@Column(name = "author")
private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

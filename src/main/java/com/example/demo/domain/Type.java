package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "type")

public class Type {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

@Column(name = "name")
    private String name;

    public void setSection(String section) {
        this.section = section;
    }

    @Column(name = "section")
    private String section;

    public String getSection() {
        return section;
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
}

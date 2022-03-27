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
    private int name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}

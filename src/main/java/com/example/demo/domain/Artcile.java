package com.example.demo.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "article")
public class Artcile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;
}

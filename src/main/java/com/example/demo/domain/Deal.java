package com.example.demo.domain;




import javax.persistence.*;

@Entity
@Table(name = "deal")

public class Deal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Piece piece;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

}

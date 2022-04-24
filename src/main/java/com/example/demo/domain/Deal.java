package com.example.demo.domain;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "deal")
@Getter
@Setter
public class Deal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Piece piece;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(name = "date")
    private String date;

    @Column(name = "sum")
    private int sum;
    @Column(name = "address")
    private String address;
}

package com.sergiomartinrubio.springbootgraphql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @Column(name = "PAYMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

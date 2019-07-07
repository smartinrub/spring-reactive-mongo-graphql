package com.sergiomartinrubio.springbootgraphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false, updatable = false)
    private Hotel hotel;

}

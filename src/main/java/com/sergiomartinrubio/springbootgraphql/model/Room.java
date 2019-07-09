package com.sergiomartinrubio.springbootgraphql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String occupants;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private Hotel hotel;

}

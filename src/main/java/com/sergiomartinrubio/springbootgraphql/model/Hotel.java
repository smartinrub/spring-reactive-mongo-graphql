package com.sergiomartinrubio.springbootgraphql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id
    @Column(name = "HOTEL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "hotel")
    private List<Room> room;

}

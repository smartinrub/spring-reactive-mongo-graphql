package com.sergiomartinrubio.springbootgraphql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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

    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "hotel")
    private List<Room> room;

}

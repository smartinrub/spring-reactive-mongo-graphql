package com.sergiomartinrubio.springbootgraphql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Room {

    @Id
    private String id;

    private String type;

    private int occupants;

    private String hotelId;

}

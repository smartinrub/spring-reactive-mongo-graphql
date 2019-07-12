package com.sergiomartinrubio.springbootgraphql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Hotel {

    @Id
    private String id;

    private String name;

    private String address;

    private LocalDateTime creationDate;

}

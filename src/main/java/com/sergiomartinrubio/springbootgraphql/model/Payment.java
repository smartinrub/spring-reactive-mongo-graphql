package com.sergiomartinrubio.springbootgraphql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Payment {

    @Id
    private String id;

    private String name;
}

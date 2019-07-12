package com.sergiomartinrubio.springbootgraphql.repository;

import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HotelRepository extends ReactiveMongoRepository<Hotel, String> {
}

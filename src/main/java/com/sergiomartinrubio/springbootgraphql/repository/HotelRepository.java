package com.sergiomartinrubio.springbootgraphql.repository;

import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
}

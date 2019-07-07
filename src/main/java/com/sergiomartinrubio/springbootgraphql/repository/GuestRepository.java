package com.sergiomartinrubio.springbootgraphql.repository;

import com.sergiomartinrubio.springbootgraphql.model.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}

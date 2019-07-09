package com.sergiomartinrubio.springbootgraphql.repository;

import com.sergiomartinrubio.springbootgraphql.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query(value = "SELECT * FROM ROOM r WHERE r.HOTEL_ID = ?1", nativeQuery = true)
    List<Room> findAllByHotelId(Long hotelId);
}

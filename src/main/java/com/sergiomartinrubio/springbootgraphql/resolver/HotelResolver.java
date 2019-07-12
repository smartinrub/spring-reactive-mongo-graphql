package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.model.Room;
import com.sergiomartinrubio.springbootgraphql.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HotelResolver implements GraphQLResolver<Hotel> {

    private final RoomRepository roomRepository;

    public Iterable<Room> getRoom(Hotel hotel) {
        return roomRepository.findAllByHotelId(hotel.getId()).toIterable();
    }

}

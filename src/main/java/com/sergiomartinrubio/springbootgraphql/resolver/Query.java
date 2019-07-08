package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sergiomartinrubio.springbootgraphql.model.Guest;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.repository.GuestRepository;
import com.sergiomartinrubio.springbootgraphql.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final GuestRepository guestRepository;
    private final HotelRepository hotelRepository;

    public Iterable<Guest> findAllGuests() {
        return guestRepository.findAll();
    }

    public Iterable<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    public long countGuests() {
        return guestRepository.count();
    }

    public long countHotels() {
        return hotelRepository.count();
    }
}

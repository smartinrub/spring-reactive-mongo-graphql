package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sergiomartinrubio.springbootgraphql.model.Guest;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GuestResolver implements GraphQLResolver<Guest> {

    private final HotelRepository hotelRepository;

    public Hotel getHotel(Guest guest) {
        return hotelRepository.findById(guest.getHotel().getId()).get();
    }

}

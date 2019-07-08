package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sergiomartinrubio.springbootgraphql.model.Guest;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.repository.GuestRepository;
import com.sergiomartinrubio.springbootgraphql.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final GuestRepository guestRepository;
    private final HotelRepository hotelRepository;

    public Guest newGuest(String firstName, String lastName, Long hotelId) {
        Guest guest = new Guest();
        guest.setFirstName(firstName);
        guest.setLastName(lastName);
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        guest.setHotel(hotel);
        guestRepository.save(guest);
        return guest;
    }

    public Hotel newHotel(String name, String address) {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotelRepository.save(hotel);
        return hotel;
    }

    public Boolean deleteGuest(Long guestId) {
        guestRepository.deleteById(guestId);
        return true;
    }

}

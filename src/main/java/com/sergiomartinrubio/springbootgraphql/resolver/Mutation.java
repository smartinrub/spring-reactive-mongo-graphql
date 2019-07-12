package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.model.Payment;
import com.sergiomartinrubio.springbootgraphql.model.Room;
import com.sergiomartinrubio.springbootgraphql.repository.HotelRepository;
import com.sergiomartinrubio.springbootgraphql.repository.PaymentRepository;
import com.sergiomartinrubio.springbootgraphql.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final PaymentRepository paymentRepository;

    public Optional<Hotel> newHotel(String name, String address) {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setCreationDate(LocalDateTime.now());
        Mono<Hotel> hotelMono = hotelRepository.save(hotel);
        return hotelMono.blockOptional();
    }

    public Optional<Room> newRoom(String type, int occupants, String hotelId) {
        Room room = new Room();
        room.setType(type);
        room.setOccupants(occupants);
        room.setHotelId(hotelId);
        Mono<Room> roomMono = roomRepository.save(room);
        return roomMono.blockOptional();
    }

    public Optional<Payment> newPayment(String name) {
        Payment payment = new Payment();
        payment.setName(name);
        Mono<Payment> paymentMono = paymentRepository.save(payment);
        return paymentMono.blockOptional();
    }

}

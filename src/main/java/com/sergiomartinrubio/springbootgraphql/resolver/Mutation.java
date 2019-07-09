package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.model.Payment;
import com.sergiomartinrubio.springbootgraphql.repository.HotelRepository;
import com.sergiomartinrubio.springbootgraphql.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final HotelRepository hotelRepository;
    private final PaymentRepository paymentRepository;

    public Hotel newHotel(String name, String address) {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotelRepository.save(hotel);
        return hotel;
    }

    public Payment newPayment(String name) {
        Payment payment = new Payment();
        payment.setName(name);
        paymentRepository.save(payment);
        return payment;
    }

}

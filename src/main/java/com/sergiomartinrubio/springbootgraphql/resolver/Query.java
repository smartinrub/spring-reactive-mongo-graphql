package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.model.Payment;
import com.sergiomartinrubio.springbootgraphql.repository.HotelRepository;
import com.sergiomartinrubio.springbootgraphql.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final HotelRepository hotelRepository;
    private final PaymentRepository paymentRepository;

    public Iterable<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> findHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public long countHotels() {
        return hotelRepository.count();
    }

    public Iterable<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }
}

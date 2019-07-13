package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.publisher.HotelPublisher;
import com.sergiomartinrubio.springbootgraphql.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Subscription implements GraphQLSubscriptionResolver {

    private final HotelRepository hotelRepository;


    public Publisher<Hotel> getNewHotel() {
        return hotelRepository.findWithTailableCursorBy();
    }
}

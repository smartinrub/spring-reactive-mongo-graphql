package com.sergiomartinrubio.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import com.sergiomartinrubio.springbootgraphql.publisher.HotelPublisher;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Subscription implements GraphQLSubscriptionResolver {

    private final HotelPublisher hotelPublisher;

    public Publisher<Hotel> getNewHotel() {
        return hotelPublisher.getPublisher();
    }
}

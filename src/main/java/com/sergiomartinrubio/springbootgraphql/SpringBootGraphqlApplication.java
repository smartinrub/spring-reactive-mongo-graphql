package com.sergiomartinrubio.springbootgraphql;

import com.sergiomartinrubio.springbootgraphql.repository.GuestRepository;
import com.sergiomartinrubio.springbootgraphql.repository.HotelRepository;
//import com.sergiomartinrubio.springbootgraphql.resolver.GuestResolver;
import com.sergiomartinrubio.springbootgraphql.resolver.Mutation;
import com.sergiomartinrubio.springbootgraphql.resolver.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphqlApplication.class, args);
    }

//    @Bean
//    public GuestResolver guestResolver(HotelRepository hotelRepository) {
//        return new GuestResolver(hotelRepository);
//    }

    @Bean
    public Query query(GuestRepository guestRepository, HotelRepository hotelRepository) {
        return new Query(guestRepository, hotelRepository);
    }

    @Bean
    public Mutation mutation(GuestRepository guestRepository, HotelRepository hotelRepository) {
        return new Mutation(guestRepository, hotelRepository);
    }

}

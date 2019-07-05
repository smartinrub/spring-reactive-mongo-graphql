package com.sergiomartinrubio.springbootgraphql;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> hotels = List.of(
            Map.of("id", "1",
                    "name", "The Venetian Las Vegas",
                    "address", "3355 Las Vegas Blvd S, Las Vegas, NV, 89109, United States of America",
                    "roomId", "1"),
            Map.of("id", "2",
                    "name", "Alexis Park All Suite Resort",
                    "address", "Alexis Park All Suite Resort",
                    "roomId", "2"),
            Map.of("id", "3",
                    "name", "Mirage Resort & Casino",
                    "address", "3400 Las Vegas Blvd S, Las Vegas, NV, 89109, United States of America",
                    "roomId", "3")

    );

    private static List<Map<String, String>> rooms = List.of(
            Map.of("id", "1",
                    "name", "Standard Double Room",
                    "rate", "50"),
            Map.of("id", "2",
                    "name", "Piazza King Suite",
                    "rate", "200"),
            Map.of("id", "3",
                    "name", "King Volcano View Room",
                    "rate", "100")
    );

    public DataFetcher getHotelByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String hotelId = dataFetchingEnvironment.getArgument("id");
            return hotels.stream()
                    .filter(hotel -> hotel.get("id").equals(hotelId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getRoomDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> hotel = dataFetchingEnvironment.getSource();
            String roomId = hotel.get("roomId");
            return rooms.stream()
                    .filter(room -> room.get("id").equals(roomId))
                    .findFirst()
                    .orElse(null);
        };
    }
}

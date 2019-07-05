package com.sergiomartinrubio.springbootgraphql;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> hotels = List.of(
            Map.of("id", "hotel-1",
                    "name", "name 1",
                    "address", "123",
                    "roomId", "room-1"),
            Map.of("id", "hotel-2",
                    "name", "name 2",
                    "address", "321",
                    "roomId", "room-2"),
            Map.of("id", "hotel-3",
                    "name", "name 3",
                    "address", "789",
                    "roomId", "room-3")

    );

    private static List<Map<String, String>> rooms = List.of(
            Map.of("id", "room-1",
                    "name", "name 1",
                    "rate", "50"),
            Map.of("id", "room-2",
                    "name", "name 2",
                    "rate", "20"),
            Map.of("id", "room-3",
                    "name", "name 1",
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

package com.sergiomartinrubio.springbootgraphql.publisher;

import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class HotelPublisher {

    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 5;

    private Flowable<Hotel> publisher;

    public HotelPublisher() {
        Observable<Hotel> hotelObservable = Observable.create(emitter -> {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(newHotel(emitter), 0, 2, TimeUnit.SECONDS);
        });

        ConnectableObservable<Hotel> connectableObservable = hotelObservable.share().publish();
        connectableObservable.connect();
        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    private Runnable newHotel(ObservableEmitter<Hotel> emitter) {
        return () -> {
            Hotel hotel = getUpdates();
            emitHotels(emitter, hotel);
        };
    }

    private void emitHotels(ObservableEmitter<Hotel> emitter, Hotel hotel) {
        emitter.onNext(hotel);
    }

    private Hotel getUpdates() {
        Hotel hotel = new Hotel();
        hotel.setName("Hotel " + getRandNumber());
        hotel.setAddress("Address " + getRandNumber());
        return hotel;
    }

    private int getRandNumber() {
        Random rand = new Random();
        return rand.nextInt((MAX_RANDOM - MIN_RANDOM) + 1) + MIN_RANDOM;
    }

    public Flowable<Hotel> getPublisher() {
        return publisher;
    }

}

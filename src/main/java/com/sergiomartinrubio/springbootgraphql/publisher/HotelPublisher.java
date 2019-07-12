package com.sergiomartinrubio.springbootgraphql.publisher;

import com.sergiomartinrubio.springbootgraphql.model.Hotel;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class HotelPublisher {

    private static int counter = 0;

    private Flowable<Hotel> publisher;

    public HotelPublisher() {
        Observable<Hotel> hotelObservable = Observable.create(emitter -> {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(addHotel(emitter), 0, 2, TimeUnit.SECONDS);
        });

        ConnectableObservable<Hotel> connectableObservable = hotelObservable.share().publish();
        connectableObservable.connect();
        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    private Runnable addHotel(ObservableEmitter<Hotel> emitter) {
        return () -> {
            Hotel hotel = createHotel();
            emitHotel(emitter, hotel);
        };
    }

    private void emitHotel(ObservableEmitter<Hotel> emitter, Hotel hotel) {
        emitter.onNext(hotel);
    }

    private Hotel createHotel() {
        Hotel hotel = new Hotel();
        hotel.setName("Hotel " + counter);
        hotel.setAddress("Address " + counter);
        counter++;
        return hotel;
    }

    public Flowable<Hotel> getPublisher() {
        return publisher;
    }

}

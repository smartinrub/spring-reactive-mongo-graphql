package com.sergiomartinrubio.springbootgraphql.repository;

import com.sergiomartinrubio.springbootgraphql.model.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {
}

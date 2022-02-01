package com.nttdata.bootcamp.customer.repository;

import com.nttdata.bootcamp.customer.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: {@link CustomerRepository}<br/>
 * @author NTTDATA <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>L.A.T.</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>07/01/2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {
   // Mono<Customer> create(Customer customerRequest);
}

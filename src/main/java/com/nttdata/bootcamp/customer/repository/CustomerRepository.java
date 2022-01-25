package com.nttdata.bootcamp.customer.repository;

import com.nttdata.bootcamp.customer.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

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

public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {
}

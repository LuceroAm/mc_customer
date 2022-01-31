package com.nttdata.bootcamp.customer.business;

import com.nttdata.bootcamp.customer.model.Customer;
import com.nttdata.bootcamp.customer.model.dto.request.CustomerRequest;
import com.nttdata.bootcamp.customer.model.dto.response.CustomerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: {@link CustomerService}<br/>
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

public interface CustomerService {
    Mono<CustomerResponse> create(CustomerRequest customerRequest);

    Mono<CustomerResponse> findById(String id);

    Flux<CustomerResponse> findAll();

    Mono<CustomerResponse> update(CustomerRequest customerRequest);

    Mono<CustomerResponse> remove(String id);
}

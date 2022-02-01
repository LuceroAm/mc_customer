package com.nttdata.bootcamp.customer.business.impl;

import com.nttdata.bootcamp.customer.business.CustomerService;
import com.nttdata.bootcamp.customer.model.Customer;
import com.nttdata.bootcamp.customer.model.dto.request.CustomerRequest;
import com.nttdata.bootcamp.customer.model.dto.response.CustomerResponse;
import com.nttdata.bootcamp.customer.repository.CustomerRepository;
import com.nttdata.bootcamp.customer.util.CustomerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * <b>Class</b>: {@link CustomerServiceImpl}<br/>
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


@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Mono<CustomerResponse> create(CustomerRequest customerRequest) {
        log.info("Guardar datos del Cliente");
        return customerRepository.save(CustomerBuilder
                .customerRequestToCustomerEntity(customerRequest))
                .map(customer -> CustomerBuilder
                        .customerEntityToCustomerResponse(customer));
    }

    @Override
    public Mono<CustomerResponse> findById(String id) {
        return customerRepository.findById(id)
                .map(customer -> CustomerBuilder
                .customerEntityToCustomerResponse(customer));
    }

    @Override
    public Flux<CustomerResponse> findAll() {
        log.info("Obtener todos los registros de los Clientes");
        return customerRepository.findAll()
                .map(customer -> CustomerBuilder
                .customerEntityToCustomerResponse(customer));
    }

    @Override
    public Mono<CustomerResponse> update(CustomerRequest customerRequest) {
        log.info("Actualizar un registro de un Cliente");
        return customerRepository.findById(customerRequest.getId())
                .flatMap(customerBD->{
                    return  create(customerRequest);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<CustomerResponse> remove(String id) {
        log.info("Eliminar un registro de un Cliente");
        return  customerRepository
                .findById(id)
                .map(customer -> CustomerBuilder
                    .customerEntityToCustomerResponse(customer))
                .flatMap(customerResponse -> customerRepository.deleteById(customerResponse.getId())
                .thenReturn(customerResponse));
    }

    @Override
    public Mono<CustomerResponse> getData(Map<String, String> params) {
        log.info("Busqueda Dinamica");
        String numberDocument;
        if (!params.isEmpty()) {
            numberDocument = params.get("numberDocument");
            return customerRepository.findAll()
                .map(customer -> CustomerBuilder
                        .customerEntityToCustomerResponse(customer))
                    .filter(customerResponse ->
                            customerResponse.getNumberDocument()
                            .equals(numberDocument))
                    .next()
                    ;
        }
        return null;

    }
}

package com.nttdata.bootcamp.web.exponse;

import com.nttdata.bootcamp.customer.business.CustomerService;
import com.nttdata.bootcamp.customer.model.Customer;
import com.nttdata.bootcamp.customer.model.dto.request.CustomerRequest;
import com.nttdata.bootcamp.customer.model.dto.response.CustomerResponse;
import com.nttdata.bootcamp.customer.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;

@RestController
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "Microservice Customer", description = "Esta API se encarga de la gestion de los Clientes")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Mono<CustomerResponse> create(@RequestBody CustomerRequest request)
    {
        log.info("Metoth Create Customer");
        return customerService.create(request);
    }

    @GetMapping
    @ApiOperation(value = Constants.GETDATA_VALUE, notes = Constants.GETDATA_NOTE)
    public Flux<CustomerResponse> findAll() {
        log.info("Metoth findAll ");
        return customerService.findAll();
    }

    @GetMapping(Constants.ID)
    @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
    public Mono<CustomerResponse> findById(@PathVariable("id") String id) {
        log.info("Metoth findById ");
        return customerService.findById(id);
    }

    @PutMapping(Constants.ID)
    @ApiOperation(value = Constants.UPDATE_ID_VALUE, notes = Constants.UPDATE_ID_NOTE)
    public Mono<ResponseEntity<CustomerResponse>> Update(@RequestBody CustomerRequest request) {
        log.info("Metoth update ");
        return customerService.update(request)
                .flatMap(customerResponse -> Mono.just(ResponseEntity.ok(customerResponse)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


    @DeleteMapping(Constants.ID)
    @ApiOperation(value = Constants.DELETE_ID_VALUE, notes = Constants.DELETE_ID_NOTE)
    public Mono<ResponseEntity<CustomerResponse>> deletebyId(@PathVariable("id") String id) {
        log.info("Metoth deletebyId ");
        return customerService.remove(id)
                .flatMap(customerResponse -> Mono.just(ResponseEntity.ok(customerResponse)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}

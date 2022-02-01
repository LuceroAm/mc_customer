package com.nttdata.bootcamp.customer.util;

import com.nttdata.bootcamp.customer.model.Customer;
import com.nttdata.bootcamp.customer.model.dto.request.CustomerRequest;
import com.nttdata.bootcamp.customer.model.dto.response.CustomerResponse;

public class CustomerBuilder {

    public final static Customer customerRequestToCustomerEntity (CustomerRequest request){
        return Customer.builder()
                .id(request.getId())
                .typeCustomer(request.getTypeCustomer())
                .entityName(request.getEntityName())
                .entityNameDescription(request.getEntityNameDescription())
                .typeDocument(request.getTypeDocument())
                .numberDocument(request.getNumberDocument())
                .telephone(request.getTelephone())
                .address(request.getAddress())
                .email(request.getEmail())
                .build();
    }

    public static CustomerResponse customerEntityToCustomerResponse(Customer model){
        return CustomerResponse.builder()
                .id(model.getId())
                .typeCustomer(model.getTypeCustomer())
                .entityName(model.getEntityName())
                .entityNameDescription(model.getEntityNameDescription())
                .typeDocument(model.getTypeDocument())
                .numberDocument(model.getNumberDocument())
                .telephone(model.getTelephone())
                .address(model.getAddress())
                .email(model.getEmail())
                .build();
    }
}

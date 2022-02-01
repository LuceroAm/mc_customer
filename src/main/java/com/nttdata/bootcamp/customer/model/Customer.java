package com.nttdata.bootcamp.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;



/**
 * <b>Class</b>: {@link Customer}<br/>
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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
@Builder
@Slf4j
public class Customer {
    @Id
    private String id = UUID.randomUUID().toString();
    private TypeCustomer typeCustomer;
    private EntityName entityName;
    private String entityNameDescription;
    private TypeDocument typeDocument;
    private String numberDocument;
    private String telephone;
    private String address;
    private String email;
}


package com.nttdata.bootcamp.customer.model.dto.request;

import com.nttdata.bootcamp.customer.model.EntityName;
import com.nttdata.bootcamp.customer.model.TypeCustomer;
import com.nttdata.bootcamp.customer.model.TypeDocument;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


/**
 * <b>Class</b>: {@link CustomerRequest}<br/>
 * @author NTTDATA <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>L.A.T.</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>06/01/2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
@Builder
public class CustomerRequest {
    @ApiModelProperty(value = "id", position = 1)
    private String id = UUID.randomUUID().toString();

    @ApiModelProperty(value = "typeCustomer", position = 2)
    private TypeCustomer typeCustomer;

    @ApiModelProperty(value = "entityName", position = 3)
    private EntityName entityName;

    @ApiModelProperty(value = "entityNameDescription", position = 4)
    private String entityNameDescription;

    @ApiModelProperty(value = "typeDocument", position = 5)
    private TypeDocument typeDocument;

    @ApiModelProperty(value = "numberDocument", position = 6)
    private String numberDocument;

    @ApiModelProperty(value = "telephone", position = 7)
    private String telephone;

    @ApiModelProperty(value = "address", position = 8)
    private String address;

    @ApiModelProperty(value = "email", position = 9)
    private String email;
}

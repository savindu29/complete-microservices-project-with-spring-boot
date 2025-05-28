package com.savindu.accountManagement.controller;

import com.savindu.AccountURI;
import com.savindu.Patterns;
import com.savindu.URIPrefix;
import com.savindu.accountManagement.dto.CustomerDetailsDto;
import com.savindu.accountManagement.service.ICustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Customer", description = "Account Management")
@RestController
@RequestMapping(path = URIPrefix.API+ AccountURI.CUSTOMER,produces ={MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CustomerController {

    private final ICustomerService customerService;
    @GetMapping(URIPrefix.GET+ AccountURI.NIC_NUMBER)
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails( @PathVariable
                                                                    @Pattern(regexp = Patterns.NIC_NUMBER, message = "NIC number is invalid")
                                                                    String nicNumber){
        // This method should be implemented to fetch customer details based on the NIC number.
        // For now, returning null or an empty response.
        return ResponseEntity.status
                (HttpStatus.OK).body(customerService.fetchCustomerDetails(nicNumber));
    }
}

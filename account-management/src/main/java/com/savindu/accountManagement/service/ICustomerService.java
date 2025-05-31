package com.savindu.accountManagement.service;

import com.savindu.accountManagement.dto.CustomerDetailsDto;
import com.savindu.accountManagement.dto.response.CustomerResponseDto;

public interface ICustomerService {
    CustomerDetailsDto fetchCustomerDetails(String nicNumber);
}

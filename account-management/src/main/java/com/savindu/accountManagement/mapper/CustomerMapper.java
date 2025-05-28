package com.savindu.accountManagement.mapper;

import com.savindu.accountManagement.dto.CustomerDetailsDto;
import com.savindu.accountManagement.dto.request.CustomerRequestDto;
import com.savindu.accountManagement.dto.response.CustomerResponseDto;
import com.savindu.accountManagement.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerResponseDto toDto(Customer aClass);
    List<CustomerResponseDto> toDtoList(List<Customer> aClassList);
    Customer toEntity(CustomerRequestDto request);
    List<Customer> toEntityList(List<CustomerResponseDto> accountDtoList);
    CustomerDetailsDto toCustomerDetailsDto(Customer customer);
}

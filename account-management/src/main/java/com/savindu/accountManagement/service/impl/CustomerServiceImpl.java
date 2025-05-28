package com.savindu.accountManagement.service.impl;

import com.savindu.accountManagement.dto.CardDto;
import com.savindu.accountManagement.dto.CustomerDetailsDto;
import com.savindu.accountManagement.dto.LoanDto;
import com.savindu.accountManagement.dto.response.CustomerResponseDto;
import com.savindu.accountManagement.entity.Account;
import com.savindu.accountManagement.entity.Customer;
import com.savindu.accountManagement.exception.ResourceNotFoundException;
import com.savindu.accountManagement.mapper.AccountMapper;
import com.savindu.accountManagement.mapper.CustomerMapper;
import com.savindu.accountManagement.repository.AccountRepository;
import com.savindu.accountManagement.repository.CustomerRepository;
import com.savindu.accountManagement.service.ICustomerService;
import com.savindu.accountManagement.service.client.CardsFeignClient;
import com.savindu.accountManagement.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String nicNumber) {
        Customer customer = customerRepository.findByNicNumber(nicNumber)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Customer", "nic number", nicNumber)
                );
        Account account = accountRepository.findByCustomerId(customer.getId())
                .orElseThrow(
                        ()->new ResourceNotFoundException("Account", "nic number", nicNumber)
                );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.INSTANCE.toCustomerDetailsDto(customer);
        customerDetailsDto.setAccount(AccountMapper.INSTANCE.toDto(account));
        ResponseEntity<CardDto> cardDtoResponseEntity = cardsFeignClient.fetchCardDetails(nicNumber);
        customerDetailsDto.setCard(cardDtoResponseEntity.getBody());
        ResponseEntity<LoanDto> loanDtoResponseEntity = loansFeignClient.fetchLoanDetails(nicNumber);
        customerDetailsDto.setLoan(loanDtoResponseEntity.getBody());
        return customerDetailsDto;


    }
}

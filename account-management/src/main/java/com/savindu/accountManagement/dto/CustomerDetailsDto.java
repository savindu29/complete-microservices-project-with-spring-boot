package com.savindu.accountManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savindu.accountManagement.dto.response.AccounResponsetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDetailsDto {
    private String name;

    private String email;

    private String mobile;
    @JsonProperty("nic_number")
    private String nicNumber;
    private AccounResponsetDto account;
    private CardDto card;
    private LoanDto loan;

}

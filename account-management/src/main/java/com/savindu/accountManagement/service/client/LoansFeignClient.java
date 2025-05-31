package com.savindu.accountManagement.service.client;

import com.savindu.LoanURI;
import com.savindu.URIPrefix;
import com.savindu.accountManagement.dto.LoanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loan")
public interface LoansFeignClient {

    @GetMapping(value = URIPrefix.API+ LoanURI.LOAN+URIPrefix.GET,consumes = "application/json")
    public ResponseEntity<LoanDto> fetchLoanDetails(@RequestParam String nicNumber);

}

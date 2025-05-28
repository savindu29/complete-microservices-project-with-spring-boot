package com.savindu.accountManagement.service.client;

import com.savindu.CardURI;
import com.savindu.Patterns;
import com.savindu.URIPrefix;
import com.savindu.accountManagement.dto.CardDto;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("card")
public interface CardsFeignClient {

    @GetMapping(value = URIPrefix.API+ CardURI.CARD+URIPrefix.GET,consumes = "application/json")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestParam String nicNumber);
}

package com.savindu.accountManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savindu.Patterns;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "Loan",
        description = "Schema to hold Loan information"
)
@Data
public class LoanDto {


    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp= Patterns.LOAN_NUMBER,message = "LoanNumber must be 12 digits")
    @Schema(
            description = "Loan Number of the customer", example = "548732457654"
    )
    @JsonProperty("loan_number")
    private String loanNumber;

    @NotEmpty(message = "LoanType can not be a null or empty")
    @Schema(
            description = "Type of the loan", example = "Home Loan"
    )
    @JsonProperty("loan_type")
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount", example = "100000"
    )
    @JsonProperty("total_loan")
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    @JsonProperty("amount_paid")
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    @JsonProperty("outstanding_amount")
    private int outstandingAmount;
}

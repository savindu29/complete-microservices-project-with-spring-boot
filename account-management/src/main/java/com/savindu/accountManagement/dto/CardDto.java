package com.savindu.accountManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savindu.Patterns;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "Card",
        description = "Schema to hold Card information"
)
@Data
public class CardDto {
    @JsonProperty("nic_number")
    @NotEmpty(message = "NIC Number can not be a null or empty")
    @Pattern(regexp= Patterns.NIC_NUMBER)
    private String nicNumber;

    @NotEmpty(message = "Card Number can not be a null or empty")
    @Pattern(regexp=Patterns.CARD_NUMBER)
    @Schema(
            description = "Card Number of the customer", example = "100646930341"
    )
    private String cardNumber;

    @NotEmpty(message = "CardType can not be a null or empty")
    @Schema(
            description = "Type of the card", example = "Credit Card"
    )
    @JsonProperty("card_type")
    private String cardType;

    @Positive(message = "Total card limit should be greater than zero")
    @Schema(
            description = "Total amount limit available against a card", example = "100000"
    )
    @JsonProperty("total_limit")
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    @Schema(
            description = "Total amount used by a Customer", example = "1000"
    )
    @JsonProperty("amount_used")
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    @Schema(
            description = "Total available amount against a card", example = "90000"
    )
    @JsonProperty("available_amount")
    private int availableAmount;

}

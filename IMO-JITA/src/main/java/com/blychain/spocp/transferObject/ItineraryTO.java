package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItineraryTO {

    @Schema(example = "12")
    @Digits(integer = 5, fraction = 0, message = "The portOfCallSequenceNumber must contain up to 5 digits")
    @Min(value = 1, message = "The portOfCallSequenceNumber must be at least 1")
    @Positive(message = "The portOfCallSequenceNumber must be positive")
    private Integer portOfCallSequenceNumber;

    @Schema(example = "1432")
    @Digits(integer = 5, fraction = 0, message = "The distanceToDestination must contain up to 5 digits")
    @Positive(message = "The distanceToDestination must be positive")
    @Min(value = 1, message = "The distanceToDestination must be at least 1")
    private Integer distanceToDestination;
}

package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItineraryTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long itineraryId;

    @Schema(example = "12")
    @NotNull(message = "The portOfCallSequenceNumber cannot be null")
    @Digits(integer = 5, fraction = 0, message = "It must contain up to 5 digits")
    @Min(value = 1, message = "It must be at least 1")
    @Positive(message = "It must be positive")
    private Integer portOfCallSequenceNumber;

    @Schema(example = "1432")
    @NotNull(message = "The distanceToDestination cannot be null")
    @Digits(integer = 5, fraction = 0, message = "It must contain up to 5 digits")
    @Positive(message = "It must be positive")
    @Min(value = 1, message = "It must be at least 1")
    private Integer distanceToDestination;
}

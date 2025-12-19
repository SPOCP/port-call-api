package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementInPortTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long movementInPortId;

    @NotNull(message = "The dateAndTimeToLocationInPortActual cannot be null")
    private OffsetDateTime dateAndTimeToLocationInPortActual;

    @NotNull(message = "The dateAndTimeToLocationInPortEstimated cannot be null")
    private OffsetDateTime dateAndTimeToLocationInPortEstimated;

    @NotNull(message = "The MovementInPort - dateAndTimeToLocationInPortRequested cannot be null")
    private OffsetDateTime dateAndTimeToLocationInPortRequested;

    @NotNull(message = "The dateAndTimeToLocationInPortPlanned cannot be null")
    private OffsetDateTime dateAndTimeToLocationInPortPlanned;

    @Valid
    private MovementInPortLocationTO movementInPortLocation;


}

package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
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

    private OffsetDateTime dateAndTimeToLocationInPortActual;

    private OffsetDateTime dateAndTimeToLocationInPortEstimated;

    private OffsetDateTime dateAndTimeToLocationInPortRequested;

    private OffsetDateTime dateAndTimeToLocationInPortPlanned;

    @Valid
    private MovementInPortLocationTO movementInPortLocation;


}

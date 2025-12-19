package com.blychain.spocp.transferObject;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaritimeServiceStartEventTO {

    @NotNull(message = "The dateAndTimeOfServiceStartActual cannot be null")
    private OffsetDateTime dateAndTimeOfServiceStartActual;

    @NotNull(message = "The dateAndTimeOfServiceStartEstimated cannot be null")
    private OffsetDateTime dateAndTimeOfServiceStartEstimated;

    @NotNull(message = "The dateAndTimeOfServiceStartPlanned cannot be null")
    private OffsetDateTime dateAndTimeOfServiceStartPlanned;

    @NotNull(message = "The dateAndTimeOfServiceStartRequested cannot be null")
    private OffsetDateTime dateAndTimeOfServiceStartRequested;
}

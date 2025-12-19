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

    @NotNull(message = "MaritimeServiceStartEvent - dateAndTimeOfServiceStartActual cannot be null.")
    private OffsetDateTime dateAndTimeOfServiceStartActual;

    @NotNull(message = "MaritimeServiceStartEvent - dateAndTimeOfServiceStartEstimated cannot be null.")
    private OffsetDateTime dateAndTimeOfServiceStartEstimated;

    @NotNull(message = "MaritimeServiceStartEvent - dateAndTimeOfServiceStartPlanned cannot be null.")
    private OffsetDateTime dateAndTimeOfServiceStartPlanned;

    @NotNull(message = "MaritimeServiceStartEvent - dateAndTimeOfServiceStartRequested cannot be null.")
    private OffsetDateTime dateAndTimeOfServiceStartRequested;
}

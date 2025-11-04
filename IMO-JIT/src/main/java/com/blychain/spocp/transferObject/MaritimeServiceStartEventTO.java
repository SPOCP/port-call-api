package com.blychain.spocp.transferObject;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaritimeServiceStartEventTO {
    private OffsetDateTime dateAndTimeOfServiceStartActual;

    private OffsetDateTime dateAndTimeOfServiceStartEstimated;

    private OffsetDateTime dateAndTimeOfServiceStartPlanned;

    private OffsetDateTime dateAndTimeOfServiceStartRequested;
}

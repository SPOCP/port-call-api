package com.blychain.spocp.transferObject;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaritimeServiceCompletionEventTO {
    private OffsetDateTime dateAndTimeOfServiceCompletionActual;

    private OffsetDateTime dateAndTimeOfServiceCompletionEstimated;

    private OffsetDateTime dateAndTimeOfServiceCompletionPlanned;

    private OffsetDateTime dateAndTimeOfServiceCompletionRequested;
}

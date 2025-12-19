package com.blychain.spocp.transferObject;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaritimeServiceCompletionEventTO {

    @NotNull(message = "The dateAndTimeOfServiceCompletionActual cannot be null")
    private OffsetDateTime dateAndTimeOfServiceCompletionActual;

    @NotNull(message = "The dateAndTimeOfServiceCompletionEstimated cannot be null")
    private OffsetDateTime dateAndTimeOfServiceCompletionEstimated;

    @NotNull(message = "The dateAndTimeOfServiceCompletionPlanned cannot be null")
    private OffsetDateTime dateAndTimeOfServiceCompletionPlanned;

    @NotNull(message = "The dateAndTimeOfServiceCompletionRequested cannot be null")
    private OffsetDateTime dateAndTimeOfServiceCompletionRequested;
}

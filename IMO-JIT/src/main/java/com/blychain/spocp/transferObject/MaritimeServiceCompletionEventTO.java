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

    @NotNull(message = "MaritimeServiceCompletionEvent - dateAndTimeOfServiceCompletionActual cannot be null.")
    private OffsetDateTime dateAndTimeOfServiceCompletionActual;

    @NotNull(message = "MaritimeServiceCompletionEvent - dateAndTimeOfServiceCompletionEstimated cannot be null.")
    private OffsetDateTime dateAndTimeOfServiceCompletionEstimated;

    @NotNull(message = "MaritimeServiceCompletionEvent - dateAndTimeOfServiceCompletionPlanned cannot be null.")
    private OffsetDateTime dateAndTimeOfServiceCompletionPlanned;

    @NotNull(message = "MaritimeServiceCompletionEvent - dateAndTimeOfServiceCompletionRequested cannot be null.")
    private OffsetDateTime dateAndTimeOfServiceCompletionRequested;
}

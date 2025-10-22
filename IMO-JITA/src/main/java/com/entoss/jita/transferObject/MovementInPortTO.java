package com.entoss.jita.transferObject;

import jakarta.validation.Valid;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementInPortTO {
    private OffsetDateTime dateAndTimeToLocationInPortActual;

    private OffsetDateTime dateAndTimeToLocationInPortEstimated;

    private OffsetDateTime dateAndTimeToLocationInPortRequested;

    private OffsetDateTime dateAndTimeToLocationInPortPlanned;

    @Valid
    private MovementInPortLocationTO movementInPortLocation;


}

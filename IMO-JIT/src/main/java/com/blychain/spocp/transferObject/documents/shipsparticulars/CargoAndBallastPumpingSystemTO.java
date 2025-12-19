package com.blychain.spocp.transferObject.documents.shipsparticulars;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CargoAndBallastPumpingSystemTO {
    @Valid
    @NotNull(message = "The ballast cannot be null")
    private PumpSystemTO ballast;

    @Valid
    @NotNull(message = "The fireGs cannot be null")
    private PumpSystemTO fireGs;

    @Valid
    @NotNull(message = "The ballastEductor cannot be null")
    private PumpSystemTO ballastEductor;
}

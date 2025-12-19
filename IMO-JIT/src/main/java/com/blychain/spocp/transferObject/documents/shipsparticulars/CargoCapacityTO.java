package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CargoCapacityTO {

    @Schema(example = "CARGO HOLD 1")
    @NotBlank(message = "CargoCapacityTO - cargoHold cannot be null")
    private String cargoHold;

    @Schema(example = "12024.2")
    @NotNull(message = "CargoCapacityTO - value cannot be null")
    private Double value;
}

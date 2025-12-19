package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TankCapacitiesTO {

    @Schema(example = "72654.2")
    @NotNull(message = "The grainTotal cannot be null")
    private Double grainTotal;

    @Schema(example = "69348")
    @NotNull(message = "The baleTotal cannot be null")
    private Double baleTotal;

    @Valid
    @NotEmpty(message = "The grain cannot be empty")
    private List<CargoCapacityTO> grain;

    @Valid
    @NotEmpty(message = "The bale cannot be empty")
    private List<CargoCapacityTO> bale;

}

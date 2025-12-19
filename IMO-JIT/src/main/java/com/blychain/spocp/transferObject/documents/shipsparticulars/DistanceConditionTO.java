package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistanceConditionTO {

    @Schema(example = "16.03 m")
    @NotBlank(message = "The hatch cannot be null or blank")
    private String hatch;

    @Schema(example = "15.24 m")
    @NotBlank(message = "The midShips cannot be null or blank")
    private String midShips;

    @Schema(example = "14.44 m")
    @NotBlank(message = "The lastHatch cannot be null or blank")
    private String lastHatch;
}

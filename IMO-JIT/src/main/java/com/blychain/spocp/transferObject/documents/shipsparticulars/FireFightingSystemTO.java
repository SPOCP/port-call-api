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
public class FireFightingSystemTO {

    @Schema(example = "CO 2 / FIXED LOCAL APPLICATION/SW Hydrant/ Portable Fire Extinguisher/ Fire Detecting System")
    @NotBlank(message = "The erm cannot be null or blank")
    private String erm;

    @Schema(example = "SW Hydrant and CO2 Fire Extinguishing System")
    @NotBlank(message = "The cargoHold cannot be null or blank")
    private String cargoHold;

    @Schema(example = "SW Hydrant")
    @NotBlank(message = "The deckArea cannot be null or blank")
    private String deckArea;
}

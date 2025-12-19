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
public class TonnageTO {

    @Schema(example = "19449")
    @NotBlank(message = "The netTonnage cannot be null or blank")
    private String netTonnage;

    @Schema(example = "32370")
    @NotBlank(message = "The grossTonnage cannot be null or blank")
    private String grossTonnage;

    @Schema(example = "5944")
    @NotBlank(message = "The grossTonnageReduced cannot be null or blank")
    private String grossTonnageReduced;
}

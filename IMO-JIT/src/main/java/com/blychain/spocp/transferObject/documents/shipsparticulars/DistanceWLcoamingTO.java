package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
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
public class DistanceWLcoamingTO {
    
    @Valid
    @NotNull(message = "The ballastCondition cannot be null")
    private DistanceConditionTO ballastCondition;

    @Valid
    @NotNull(message = "The fullBallastCondition cannot be null")
    private DistanceConditionTO fullBallastCondition;

    @Valid
    @NotNull(message = "The lightCondition cannot be null")
    private DistanceConditionTO lightCondition;

    @Valid
    @NotNull(message = "The fullLadenCondition cannot be null")
    private DistanceConditionTO fullLadenCondition;

    @Schema(example = "123")
    @NotBlank(message = "The distanceFromKeelToTopOfHatchCoaming cannot be null or blank")
    private String distanceFromKeelToTopOfHatchCoaming;
}

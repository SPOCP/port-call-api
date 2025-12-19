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
public class LoadConditionValuesTO {

    @Schema(example = "38.720 m")
    @NotBlank(message = "The tropical cannot be null or blank")
    private String tropical;

    @Schema(example = "37.655 m")
    @NotBlank(message = "The summer cannot be null or blank")
    private String summer;

    @Schema(example = "36.592 m")
    @NotBlank(message = "The winter cannot be null or blank")
    private String winter;

    @Schema(example = "39.934 m")
    @NotBlank(message = "The tropicalLumbar cannot be null or blank")
    private String tropicalLumbar;

    @Schema(example = "38.841 m")
    @NotBlank(message = "The summerLumbar cannot be null or blank")
    private String summerLumbar;

    @Schema(example = "37.387 m")
    @NotBlank(message = "The winterLumbar cannot be null or blank")
    private String winterLumbar;

    @Schema(example = "15.46")
    @NotBlank(message = "The normalBallast cannot be null or blank")
    private String normalBallast;

    @Schema(example = "34923 mt")
    @NotBlank(message = "The heavyBallast cannot be null or blank")
    private String heavyBallast;
}

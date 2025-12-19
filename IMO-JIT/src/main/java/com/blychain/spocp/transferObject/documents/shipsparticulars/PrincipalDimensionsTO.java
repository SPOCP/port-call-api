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
public class PrincipalDimensionsTO {
    @Schema(example = "189.99 M")
    @NotBlank(message = "The loa cannot be null or blank")
    private String loa;

    @Schema(example = "185.78 M")
    @NotBlank(message = "The lbp cannot be null or blank")
    private String lbp;

    @Schema(example = "32.26 M")
    @NotBlank(message = "The breadth cannot be null or blank")
    private String breadth;

    @Schema(example = "18.00 M")
    @NotBlank(message = "The depth cannot be null or blank")
    private String depth;

    @Schema(example = "47.516 M")
    @NotBlank(message = "The heightMax cannot be null or blank")
    private String heightMax;

    @Schema(example = "162.72 M")
    @NotBlank(message = "The bridgeFrontToBow cannot be null or blank")
    private String bridgeFrontToBow;

    @Schema(example = "27.27 M")
    @NotBlank(message = "The bridgeFrontToStern cannot be null or blank")
    private String bridgeFrontToStern;

    @Schema(example = "9974")
    @NotBlank(message = "The lightShipDisplacement cannot be null or blank")
    private String lightShipDisplacement;

    @Valid
    @NotNull(message = "The regd cannot be null")
    private TonnageTO regd;

    @Valid
    @NotNull(message = "The suez cannot be null")
    private TonnageTO suez;

    @Valid
    @NotNull(message = "The panam cannot be null")
    private PanamTO panam;

}

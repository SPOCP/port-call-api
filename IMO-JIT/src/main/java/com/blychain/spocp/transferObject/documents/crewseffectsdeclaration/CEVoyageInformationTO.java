package com.blychain.spocp.transferObject.documents.crewseffectsdeclaration;

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
public class CEVoyageInformationTO {

    @Schema(example = "Ocean Voyager")
    @NotBlank(message = "The nameOfShip cannot be null or blank")
    private String nameOfShip;

    @Schema(example = "IMO9876543")
    @NotBlank(message = "The imoNumber cannot be null or blank")
    private String imoNumber;

    @Schema(example = "VTAB")
    @NotBlank(message = "The callSign cannot be null or blank")
    private String callSign;

    @Schema(example = "OV-IND-0224")
    @NotBlank(message = "The voyageNumber cannot be null or blank")
    private String voyageNumber;

    @Schema(example = "India")
    @NotBlank(message = "The flagState cannot be null or blank")
    private String flagState;

}

package com.blychain.spocp.transferObject.documents.dangerousgoodsmanifest;

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
public class DGVoyageInformationTO {

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

    @Schema(example = "Jawaharlal Nehru Port")
    @NotBlank(message = "The currentPort cannot be null or blank")
    private String currentPort;

    @Schema(example = "120")
    @NotNull(message = "The numberOfPersonsOnBoard cannot be null")
    private Integer numberOfPersonsOnBoard;

    @Schema(example = "7 Days")
    @NotBlank(message = "The periodOfStay cannot be null or blank")
    private String periodOfStay;

    @Schema(example = "Port of Singapore")
    @NotBlank(message = "The portOfLoading cannot be null or blank")
    private String portOfLoading;

    @Schema(example = "Jawaharlal Nehru Port")
    @NotBlank(message = "The portOfDischarge cannot be null or blank")
    private String portOfDischarge;

    @Schema(example = "Deck A")
    @NotBlank(message = "The stowagePosition cannot be null or blank")
    private String stowagePosition;

    @Schema(example = "REF123")
    @NotBlank(message = "The referenceNumber cannot be null or blank")
    private String referenceNumber;

}

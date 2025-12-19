package com.blychain.spocp.transferObject.documents.cargodeclaration;

import com.blychain.spocp.transferObject.documents.MasterContactTO;
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
public class CDVoyageInformationTO {

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

    @Schema(example = "Jawaharlal Nehru Port, Mumbai")
    @NotBlank(message = "The portOfReport cannot be null or blank")
    private String portOfReport;

    @Schema(example = "Chennai Port")
    @NotBlank(message = "The measurement cannot be null or blank")
    private String portOfDischarge;

    @Schema(example = "Port of Singapore")
    @NotBlank(message = "The portOfLoading cannot be null or blank")
    private String portOfLoading;

    @Valid
    @NotNull(message = "The masterContact cannot be null")
    private MasterContactTO masterContact;

}

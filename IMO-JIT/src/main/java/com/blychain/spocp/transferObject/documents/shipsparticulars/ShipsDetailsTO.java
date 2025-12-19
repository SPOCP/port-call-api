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
public class ShipsDetailsTO {

    @Schema(example = "VROR5")
    @NotBlank(message = "The callSign cannot be null or blank")
    private String callSign;

    @Schema(example = "HONG KONG")
    @NotBlank(message = "The flag cannot be null or blank")
    private String flag;

    @Schema(example = "HONG KONG")
    @NotBlank(message = "The portOfRegistry cannot be null or blank")
    private String portOfRegistry;

    @Schema(example = "HK-4373")
    @NotBlank(message = "The officialNumber cannot be null or blank")
    private String officialNumber;

    @Schema(example = "9707637")
    @NotBlank(message = "The imoLloydsNumber cannot be null or blank")
    private String imoLloydsNumber;

    @Schema(example = "NK")
    @NotBlank(message = "The classSociety cannot be null or blank")
    private String classSociety;

    @Schema(example = "GARD")
    @NotBlank(message = "The piClub cannot be null or blank")
    private String piClub;

    @Schema(example = "NS*(CSR, BC-A, BC-XII, GRAB 20, PSPC-WBT)")
    @NotBlank(message = "The classNotationsLine1 cannot be null or blank")
    private String classNotationsLine1;

    @Schema(example = "(ESP)(IWS)(PSCM)(BWTS)(IHM)MNS*(M0)")
    @NotBlank(message = "The classNotationsLine2 cannot be null or blank")
    private String classNotationsLine2;

    @Valid
    @NotNull(message = "The shipsParticulars cannot be null")
    private ShipsParticularsTO shipsParticulars;

    @Valid
    @NotNull(message = "The companyDetails cannot be null")
    private CompanyDetailsTO companyDetails;

}

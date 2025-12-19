package com.blychain.spocp.transferObject.documents.cargodeclaration;

import com.blychain.spocp.transferObject.documents.AuthenticationInformationTO;
import com.blychain.spocp.transferObject.documents.DocTypeTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CargoDeclarationTO {

    @Valid
    @NotNull(message = "The docType cannot be null")
    private DocTypeTO docType;

    @Valid
    @NotNull(message = "The authenticationInformation cannot be null")
    private AuthenticationInformationTO authenticationInformation;

    @Valid
    @NotNull(message = "The voyageInformation cannot be null")
    private CDVoyageInformationTO voyageInformation;

    @Valid
    @NotEmpty(message = "The cargoItems cannot be empty")
    private List<CargoItemsTO> cargoItems;
}

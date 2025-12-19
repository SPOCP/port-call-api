package com.blychain.spocp.transferObject.documents.shipsstore;

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
public class ShipsStoreDeclarationTO {

    @Valid
    @NotNull(message = "The docType cannot be null")
    private DocTypeTO docType;

    @Valid
    @NotNull(message = "The authenticationInformation cannot be null")
    private AuthenticationInformationTO authenticationInformation;

    @Valid
    @NotNull(message = "The voyageInformation cannot be null")
    private SSVoyageInformationTO voyageInformation;

    @Valid
    @NotEmpty(message = "The storesItems cannot be empty")
    private List<StoresItemsTO> storesItems;
}

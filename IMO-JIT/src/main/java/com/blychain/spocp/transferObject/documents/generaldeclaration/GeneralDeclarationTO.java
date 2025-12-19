package com.blychain.spocp.transferObject.documents.generaldeclaration;

import com.blychain.spocp.transferObject.documents.AuthenticationInformationTO;
import com.blychain.spocp.transferObject.documents.DocTypeTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralDeclarationTO {

    @Valid
    @NotNull(message = "The docType cannot be null")
    private DocTypeTO docType;

    @Valid
    @NotNull(message = "The authenticationInformation cannot be null")
    private AuthenticationInformationTO authenticationInformation;

    @Valid
    @NotNull(message = "The voyageInformation cannot be null")
    private GDVoyageInformationTO voyageInformation;
}

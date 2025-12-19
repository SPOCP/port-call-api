package com.blychain.spocp.transferObject.documents.crewlist;

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
public class CrewListTO {

    @Valid
    @NotNull(message = "The docType cannot be null")
    private DocTypeTO docType;

    @Valid
    @NotNull(message = "The authenticationInformation cannot be null")
    private AuthenticationInformationTO authenticationInformation;

    @Valid
    @NotNull(message = "The voyageInformation cannot be null")
    private CLVoyageInformationTO voyageInformation;

    @Valid
    @NotEmpty(message = "The crewMembers cannot be empty")
    private List<CrewMembersTO> crewMembers;

}

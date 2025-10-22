package com.entoss.jita.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDetailsTO {
    @Schema(example = "Taylor")
    @Size(max = 70, message = "The length of serviceProviderContactFamilyName cannot be more than 70")
    private String serviceProviderContactFamilyName;

    @Schema(example = "Chris")
    @Size(max = 70, message = "The length of serviceProviderContactGivenName cannot be more than 70")
    private String serviceProviderContactGivenName;

    @Valid
    private CommunicationTO communication;

}

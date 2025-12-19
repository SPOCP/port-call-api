package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDetailsTO {

    @Schema(example = "Taylor")
    @NotBlank(message = "The serviceProviderContactFamilyName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z][A-Za-z '-]*$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 70, message = "The length cannot be more than 70")
    private String serviceProviderContactFamilyName;


    @Schema(example = "Chris")
    @NotBlank(message = "The serviceProviderContactGivenName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z][A-Za-z '-]*$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 70, message = "The length cannot be more than 70")
    private String serviceProviderContactGivenName;


    @Valid
    private CommunicationTO communication;

}

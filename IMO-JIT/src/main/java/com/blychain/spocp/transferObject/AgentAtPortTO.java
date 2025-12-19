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
public class AgentAtPortTO {

    @Schema(example = "AGT123456")
    @NotBlank(message = "The agentIdentificationNumber cannot be null")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 17, message = "The length cannot be more than 17")
    private String agentIdentificationNumber;

    @Schema(example = "BlueWave Maritime Services")
    @NotBlank(message = "The agentName cannot be null")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .,&'-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 70, message = "The length cannot be more than 70")
    private String agentName;

    @Schema(example = "Doe")
    @NotBlank(message = "The agentContactFamilyName cannot be null")
    @Pattern(
            regexp = "^$|^[A-Za-z .'-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 70, message = "The length cannot be more than 70")
    private String agentContactFamilyName;

    @Schema(example = "John")
    @NotBlank(message = "The agentContactGivenName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z .'-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 70, message = "The length cannot be more than 70")
    private String agentContactGivenName;


    @Valid
    private AgentAtPortCommunicationTO agentAtPortCommunication;

    @Valid
    private AgentAtPortAddressTO agentAtPortAddress;

}

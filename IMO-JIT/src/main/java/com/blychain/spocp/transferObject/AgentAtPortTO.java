package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentAtPortTO {

    @Schema(example = "AGT123456")
    @Size(max = 17, message = "The length of agentIdentificationNumber cannot be more than 17")
    private String agentIdentificationNumber;

    @Schema(example = "BlueWave Maritime Services")
    @Size(max = 70, message = "The length of agentName cannot be more than 70")
    private String agentName;

    @Schema(example = "Doe")
    @Size(max = 70, message = "The length of agentContactFamilyName cannot be more than 70")
    private String agentContactFamilyName;

    @Schema(example = "John")
    @Size(max = 70, message = "The length of agentContactGivenName cannot be more than 70")
    private String agentContactGivenName;

    @Valid
    private AgentAtPortCommunicationTO agentAtPortCommunication;

    @Valid
    private AgentAtPortAddressTO agentAtPortAddress;

}

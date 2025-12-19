package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentAtPortAddressTO {

    @Schema(example = "IN")
    @NotBlank(message = "AgentAtPortAddress - agentCountryCode cannot be null.")
    @Pattern(regexp = "^[A-Z]{2}$", message = "AgentAtPortAddress - agentCountryCode: Invalid value. Please check the field format.")
    private String agentCountryCode;

    @Schema(example = "11 Marine Drive")
    @Pattern(regexp = "^[A-Za-z0-9 .,'/#-]+$", message = "AgentAtPortAddress - agentStreetAndNumber: Invalid value. Please check the field format.")
    @Size(max = 256, message = "The length of AgentAtPortAddress - agentStreetAndNumber cannot be more than 256.")
    private String agentStreetAndNumber;

    @Schema(example = "Mumbai")
    @NotBlank(message = "AgentAtPortAddress - agentCity cannot be null.")
    @Pattern(regexp = "^[A-Za-z0-9 .,'/-]+$", message = "AgentAtPortAddress - agentCity: Invalid value. Please check the field format.")
    @Size(max = 35, message = "The length of AgentAtPortAddress - agentCity cannot be more than 35.")
    private String agentCity;

    @Schema(example = "Maharashtra")
    @NotBlank(message = "AgentAtPortAddress - agentCountrySubDivisionName cannot be null.")
    @Pattern(regexp = "^[A-Za-z .,'/-]+$", message = "AgentAtPortAddress - agentCountrySubDivisionName: Invalid value. Please check the field format.")
    @Size(max = 35, message = "The length of AgentAtPortAddress - agentCountrySubDivisionName cannot be more than 35.")
    private String agentCountrySubDivisionName;

    @Schema(example = "400001")
    @Pattern(regexp = "^[A-Za-z0-9 -]+$", message = "AgentAtPortAddress - agentPostCode: Invalid value. Please check the field format.")
    @Size(max = 9, message = "The length of AgentAtPortAddress - agentPostCode cannot be more than 9.")
    private String agentPostCode;

    @Schema(example = "PO1234")
    @Pattern(regexp = "^[A-Za-z0-9 .-]+$", message = "AgentAtPortAddress - agentPOBox: Invalid value. Please check the field format.")
    @Size(max = 256, message = "The length of AgentAtPortAddress - agentPOBox cannot be more than 256.")
    private String agentPOBox;

}

package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentAtPortCommunicationTO {

    @Schema(example = "john.doe@bluewave.com")
    @NotBlank(message = "AgentAtPortCommunication - agentEmail cannot be null.")
    @Email(message = "AgentAtPortCommunication - agentEmail: Invalid value. Please check the field format.")
    @Size(max = 50, message = "The length of AgentAtPortCommunication - agentEmail cannot be more than 50.")
    private String agentEmail;

    @Schema(example = "+91-2267891234")
    @Pattern(
            regexp = "^\\+?[0-9][0-9\\- ]+$",
            message = "AgentAtPortCommunication - agentLandlineNumber: Invalid value. Please check the field format."
    )
    @Size(max = 50, message = "The length of AgentAtPortCommunication - agentLandlineNumber cannot be more than 50.")
    private String agentLandlineNumber;

    @Schema(example = "+91-9876543210")
    @NotBlank(message = "AgentAtPortCommunication - agentMobileNumber cannot be null.")
    @Pattern(
            regexp = "^\\+?[0-9][0-9\\- ]+$",
            message = "AgentAtPortCommunication - agentMobileNumber: Invalid value. Please check the field format."
    )
    @Size(max = 50, message = "The length of AgentAtPortCommunication - agentMobileNumber cannot be more than 50.")
    private String agentMobileNumber;

}

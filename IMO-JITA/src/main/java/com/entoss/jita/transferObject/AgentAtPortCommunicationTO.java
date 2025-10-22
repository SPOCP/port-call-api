package com.entoss.jita.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentAtPortCommunicationTO {

    @Schema(example = "john.doe@bluewave.com")
    @Size(max = 50, message = "The length of agentEmail cannot be more than 50")
    private String agentEmail;

    @Schema(example = "+91-2267891234")
    @Size(max = 50, message = "The length of agentLandlineNumber cannot be more than 50")
    private String agentLandlineNumber;

    @Schema(example = "+91-9876543210")
    @Size(max = 50, message = "The length of agentMobileNumber cannot be more than 50")
    private String agentMobileNumber;

}

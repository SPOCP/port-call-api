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
    @NotBlank(message = "The agentEmail cannot be null or blank")
    @Email(message = "Invalid value. Please check the field format")
    @Size(max = 50, message = "The length cannot be more than 50")
    private String agentEmail;

    @Schema(example = "+91-2267891234")
    @Pattern(
            regexp = "^$|^\\+?[0-9]{1,4}([ -]?[0-9]{2,15})+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 50, message = "The length cannot be more than 50")
    private String agentLandlineNumber;

    @Schema(example = "+91-9876543210")
    @NotBlank(message = "The agentMobileNumber cannot be null or blank")
    @Pattern(
            regexp = "^$|^\\+?[0-9]{1,4}([ -]?[0-9]{2,15})+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 50, message = "The length cannot be more than 50")
    private String agentMobileNumber;

}

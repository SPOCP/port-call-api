package com.entoss.jita.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentAtPortAddressTO {

    @Schema(example = "IN")
    @Size(min = 2, max = 2, message = "The length of agentCountryCode cannot be more than 2")
    private String agentCountryCode;

    @Schema(example = "11 Marine Drive")
    @Size(max = 256, message = "The length of agentStreetAndNumber cannot be more than 256")
    private String agentStreetAndNumber;

    @Schema(example = "Mumbai")
    @Size(max = 35, message = "The length of agentCity cannot be more than 35")
    private String agentCity;

    @Schema(example = "Maharashtra")
    @Size(max = 35, message = "The length of agentCountrySubDivisionName cannot be more than 35")
    private String agentCountrySubDivisionName;

    @Schema(example = "400001")
    @Size(max = 9, message = "The length of agentPostCode cannot be more than 9")
    private String agentPostCode;

    @Schema(example = "PO1234")
    @Size(max = 256, message = "The length of agentPOBox cannot be more than 256")
    private String agentPOBox;

}

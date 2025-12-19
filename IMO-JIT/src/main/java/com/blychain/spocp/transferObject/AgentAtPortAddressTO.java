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
    @NotBlank(message = "The agentCountryCode cannot be null or blank")
    @Pattern(regexp = "^$|^[A-Z]{2}$", message = "Invalid value. Please check the field format.")
    private String agentCountryCode;

    @Schema(example = "11 Marine Drive")
    @Pattern(regexp = "^$|^[A-Za-z0-9 .,'/#-]+$",
            message = "Invalid value. Please check the field format")
    @Size(max = 256, message = "The length cannot be more than 256")
    private String agentStreetAndNumber;

    @Schema(example = "Mumbai")
    @NotBlank(message = "The agentCity cannot be null or blank")
    @Pattern(regexp = "^$|^[A-Za-z0-9 .,'/-]+$", message = "Invalid value. Please check the field format")
    @Size(max = 35, message = "The length cannot be more than 35")
    private String agentCity;

    @Schema(example = "Maharashtra")
    @NotBlank(message = "The agentCountrySubDivisionName cannot be null or blank")
    @Pattern(regexp = "^$|^[A-Za-z .,'/-]+$",
            message = "Invalid value. Please check the field format")
    @Size(max = 35, message = "The length cannot be more than 35")
    private String agentCountrySubDivisionName;

    @Schema(example = "400001")
    @Pattern(regexp = "^$|^[A-Za-z0-9 -]+$", message = "Invalid value. Please check the field format")
    @Size(max = 9, message = "The length cannot be more than 9")
    private String agentPostCode;

    @Schema(example = "PO1234")
    @Pattern(regexp = "^$|^[A-Za-z0-9 .-]+$", message = "Invalid value. Please check the field format")
    @Size(max = 256, message = "The length cannot be more than 256")
    private String agentPOBox;

}

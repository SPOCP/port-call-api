package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunicationTO {
    @Schema(example = "chris.taylor@marinecargo.in")
    @Size(max = 50, message = "The length of serviceContactEmail cannot be more than 50")
    private String serviceContactEmail;

    @Schema(example = "+91-2223456789")
    @Size(max = 50, message = "The length of serviceContactLandlineNumber cannot be more than 50")
    private String serviceContactLandlineNumber;

    @Schema(example = "+91-9988776655")
    @Size(max = 50, message = "The length of serviceContactMobileNumber cannot be more than 50")
    private String serviceContactMobileNumber;

    @Schema(example = "https://www.marinecargo.in")
    @Size(max = 256, message = "The length of serviceURL cannot be more than 256")
    private String serviceURL;
}

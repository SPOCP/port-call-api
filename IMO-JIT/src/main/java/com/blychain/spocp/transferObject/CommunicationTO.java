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
public class CommunicationTO {

    @Schema(example = "chris.taylor@marinecargo.in")
    @Email(message = "Communication - serviceContactEmail has an invalid email.")
    @NotBlank(message = "Communication - serviceContactEmail cannot be null.")
    @Size(max = 50, message = "The length of Communication - serviceContactEmail cannot be more than 50.")
    private String serviceContactEmail;

    @Schema(example = "+91-2223456789")
    @Pattern(
            regexp = "^\\+?[0-9]{1,4}[- ]?[0-9]{6,15}$",
            message = "Communication - serviceContactLandlineNumber: Invalid value. Please check the field format."
    )
    @Size(max = 50, message = "The length of Communication - serviceContactLandlineNumber cannot be more than 50.")
    private String serviceContactLandlineNumber;

    @Schema(example = "+91-9988776655")
    @NotBlank(message = "Communication - serviceContactMobileNumber cannot be null.")
    @Pattern(
            regexp = "^\\+?[0-9]{1,4}[- ]?[0-9]{6,15}$",
            message = "Communication - serviceContactMobileNumber: Invalid value. Please check the field format."
    )
    @Size(max = 50, message = "The length of Communication - serviceContactMobileNumber cannot be more than 50.")
    private String serviceContactMobileNumber;

    @Schema(example = "https://www.marinecargo.in")
    @Pattern(
            regexp = "^(https?:\\/\\/)([A-Za-z0-9.-]+)(\\.[A-Za-z]{2,})(:\\d+)?(\\/.*)?$",
            message = "Communication - serviceURL: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of Communication - serviceURL cannot be more than 256.")
    private String serviceURL;
}

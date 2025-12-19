package com.blychain.spocp.transferObject;

import com.blychain.spocp.validator.ValidPrimaryPurposeCallCodes;
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
public class PrimaryPurposesOfCallTO {

    @Schema(example = "1")
    @NotBlank(message = "PrimaryPurposesOfCall - primaryPurposeOfCallCoded cannot be null.")
    @Pattern(
            regexp = "^[0-9]+$",
            message = "PrimaryPurposesOfCall - primaryPurposeOfCallCoded: Invalid value. Please check the field format."
    )
    @Size(max = 3, message = "The length of PrimaryPurposesOfCall - primaryPurposeOfCallCoded cannot be more than 3")
    @ValidPrimaryPurposeCallCodes
    private String primaryPurposeOfCallCoded;

}


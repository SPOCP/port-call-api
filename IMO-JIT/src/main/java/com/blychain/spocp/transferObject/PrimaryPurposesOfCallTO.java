package com.blychain.spocp.transferObject;

import com.blychain.spocp.validator.ValidPrimaryPurposeCallCodes;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrimaryPurposesOfCallTO {

    @Schema(example = "1")
    @Size(min = 1, max = 3, message = "The length of primaryPurposeOfCallCoded cannot be more than 3")
    @NotBlank(message = "The PrimaryPurposesOfCall - primaryPurposeOfCallCoded cannot be null")
    @ValidPrimaryPurposeCallCodes
    private String primaryPurposeOfCallCoded;
}


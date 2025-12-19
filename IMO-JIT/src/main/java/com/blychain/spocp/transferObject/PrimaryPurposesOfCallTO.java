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
    @NotBlank(message = "The primaryPurposeOfCallCoded cannot be null or blank")
    @Pattern(
            regexp = "^$|^[0-9]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 3, message = "The length cannot be more than 3")
    @ValidPrimaryPurposeCallCodes
    private String primaryPurposeOfCallCoded;

}


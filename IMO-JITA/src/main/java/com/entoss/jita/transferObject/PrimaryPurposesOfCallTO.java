package com.entoss.jita.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrimaryPurposesOfCallTO {

    @Schema(example = "1")
    @Size(max = 3, message = "The length of primaryPurposeOfCallCoded cannot be more than 3")
    private String primaryPurposeOfCallCoded;
}


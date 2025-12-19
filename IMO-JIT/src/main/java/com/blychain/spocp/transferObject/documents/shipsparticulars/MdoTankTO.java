package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MdoTankTO {
    @Schema(example = "NO.1 S")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "364.5")
    @NotBlank(message = "The value cannot be null or blank")
    private String value;
}

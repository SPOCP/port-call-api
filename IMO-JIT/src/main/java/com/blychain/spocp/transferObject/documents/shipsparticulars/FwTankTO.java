package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FwTankTO {

    @Schema(example = "FWP")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "156")
    @NotNull(message = "The value cannot be null or blank")
    private Double value;
}

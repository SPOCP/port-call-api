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
public class PumpSystemTO {

    @Schema(example = "BALLAST P/P")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "2")
    @NotNull(message = "The quantity cannot be null")
    private Integer quantity;

    @Schema(example = "700 m3/h")
    @NotBlank(message = "The capacity cannot be null or blank")
    private String capacity;

    @Schema(example = "700 m3/h")
    @NotBlank(message = "The head cannot be null or blank")
    private String head;
}

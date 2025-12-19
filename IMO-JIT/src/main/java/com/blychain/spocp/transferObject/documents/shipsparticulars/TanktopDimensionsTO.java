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
public class TanktopDimensionsTO {

    @Schema(example = "18.2 m * 17.3 m")
    @NotBlank(message = "The hold1 cannot be null or blank")
    private String hold1;

    @Schema(example = "16.2 m * 11.25 m")
    @NotBlank(message = "The hold2 cannot be null or blank")
    private String hold2;

    @Schema(example = "17.2 m * 14 m")
    @NotBlank(message = "The hold3 cannot be null or blank")
    private String hold3;

    @Schema(example = "13.2 m * 18.6 m")
    @NotBlank(message = "The hold4 cannot be null or blank")
    private String hold4;

    @Schema(example = "15.2 m * 13.1 m")
    @NotBlank(message = "The hold5 cannot be null or blank")
    private String hold5;
}

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
public class HatchCoverSizeTO {

    @Schema(example = "18.2 m * 17 m")
    @NotBlank(message = "The h1 cannot be null or blank")
    private String h1;

    @Schema(example = "21.16 m * 18.6 m")
    @NotBlank(message = "The h2 cannot be null or blank")
    private String h2;

    @Schema(example = "20.16 m * 18.6 m")
    @NotBlank(message = "The h5 cannot be null or blank")
    private String h5;
    
}

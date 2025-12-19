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
public class SwbtTO {

    @Schema(example = "SWT 1 P/S")
    @NotBlank(message = "SwbtTO - name cannot be null")
    private String name;

    @Schema(example = "1314.8")
    @NotNull(message = "SwbtTO - name cannot be null")
    private Double swbtp;

    @Schema(example = "1314.8")
    @NotNull(message = "SwbtTO - name cannot be null")
    private Double swbts;
}

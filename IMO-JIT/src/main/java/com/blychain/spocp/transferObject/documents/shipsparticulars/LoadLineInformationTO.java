package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
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
public class LoadLineInformationTO {

    @Schema(example = "238 mm")
    @NotBlank(message = "The fwa cannot be null or blank")
    private String fwa;

    @Schema(example = "49.1 mt")
    @NotBlank(message = "The tpcForSummerDraft cannot be null or blank")
    private String tpcForSummerDraft;

    @Valid
    @NotNull(message = "The freeBoard cannot be null")
    private LoadConditionValuesTO freeBoard;

    @Valid
    @NotNull(message = "The draft cannot be null")
    private LoadConditionValuesTO draft;

    @Valid
    @NotNull(message = "The dwt cannot be null")
    private LoadConditionValuesTO dwt;
}

package com.blychain.spocp.transferObject.documents.shipsstore;

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
public class StoresItemsTO {

    @Schema(example = "Food Provisions")
    @NotBlank(message = "The nameOfArticle cannot be null or blank")
    private String nameOfArticle;

    @Schema(example = "180")
    @NotNull(message = "The quantity cannot be null or blank")
    private Double quantity;

    @Schema(example = "Galley")
    @NotBlank(message = "The locationOnBoard cannot be null or blank")
    private String locationOnBoard;

    @Schema(example = "Crew consumption")
    @NotBlank(message = "The officialUse cannot be null or blank")
    private String officialUse;
}

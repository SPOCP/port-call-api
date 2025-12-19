package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LumbarOrLogCapacityTO {

    @Schema(example = "[4438,5766.2]")
    @NotEmpty(message = "The deck cannot be empty")
    private List<Double> deck;

    @Schema(example = "[4438,5766.2]")
    @NotEmpty(message = "The hold cannot be empty")
    private List<Double> hold;

    @Schema(example = "26581.9")
    @NotBlank(message = "The deckTotal cannot be null or blank")
    private String deckTotal;

    @Schema(example = "45238")
    @NotBlank(message = "The holdTotal cannot be null or blank")
    private String holdTotal;
}

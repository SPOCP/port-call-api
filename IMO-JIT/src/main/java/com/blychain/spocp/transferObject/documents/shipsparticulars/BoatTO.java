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
public class BoatTO {

    @Schema(example = "25")
    @NotNull(message = "The noOfPerson cannot be null")
    private Integer noOfPerson;

    @Schema(example = "7.5 m * 2.75 m * 3.4 m")
    @NotBlank(message = "The size cannot be null or blank")
    private String size;
}

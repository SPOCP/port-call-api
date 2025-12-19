package com.blychain.spocp.transferObject.documents.cargodeclaration;

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
public class CargoItemsTO {

    @Schema(example = "BL-001")
    @NotBlank(message = "The blNumber cannot be null or blank")
    private String blNumber;

    @Schema(example = "CONT-IND-001")
    @NotBlank(message = "The marksAndNumbers cannot be null or blank")
    private String marksAndNumbers;

    @Schema(example = "Electrical machinery and equipment")
    @NotBlank(message = "The description cannot be null or blank")
    private String description;

    @Schema(example = "850440")
    @NotBlank(message = "The hsCode cannot be null or blank")
    private String hsCode;

    @Schema(example = "980 kg")
    @NotBlank(message = "The grossWeight cannot be null or blank")
    private String grossWeight;

    @Schema(example = "9.8 cubic meters")
    @NotBlank(message = "The measurement cannot be null or blank")
    private String measurement;
}

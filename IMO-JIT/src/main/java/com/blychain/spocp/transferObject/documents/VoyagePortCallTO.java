package com.blychain.spocp.transferObject.documents;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoyagePortCallTO {

    @Schema(example = "Port of Singapore")
    @NotBlank(message = "The portName cannot be null or blank")
    private String portName;

    @Schema(example = "Singapore")
    @NotBlank(message = "The country cannot be null or blank")
    private String country;

    @Schema(example = "2024-02-15")
    @NotNull(message = "The arrivalDate cannot be null")
    private LocalDate arrivalDate;

    @Schema(example = "2024-02-15")
    @NotNull(message = "The departureDate cannot be null")
    private LocalDate departureDate;

    @Schema(example = "yes")
    @NotBlank(message = "The load cannot be null or blank")
    private String load;

    @Schema(example = "no")
    @NotBlank(message = "The discharge cannot be null or blank")
    private String discharge;
}

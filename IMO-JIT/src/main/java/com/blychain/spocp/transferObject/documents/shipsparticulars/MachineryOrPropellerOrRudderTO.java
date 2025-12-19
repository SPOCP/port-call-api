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
public class MachineryOrPropellerOrRudderTO {

    @Schema(example = "MITSUI MAN B&W 6S50ME-C8.2")
    @NotBlank(message = "The mainEngine cannot be null or blank")
    private String mainEngine;

    @Schema(example = "8200 kW x 108 rpm")
    @NotBlank(message = "The mcr cannot be null or blank")
    private String mcr;

    @Schema(example = "6970 kW x 102 rpm")
    @NotBlank(message = "The ncr cannot be null or blank")
    private String ncr;

    @Schema(example = "55~66 RPM")
    @NotBlank(message = "The maxCriticalRange cannot be null or blank")
    private String maxCriticalRange;

    @Schema(example = "OSAKA BOILER VERTICAL COMPOSITE")
    @NotBlank(message = "The auxBoiler cannot be null or blank")
    private String auxBoiler;

    @Schema(example = "20 kW x 450 V x 60 Hz")
    @NotBlank(message = "The generator cannot be null or blank")
    private String generator;

    @Schema(example = "80 kW x 450 V x 60 Hz")
    @NotBlank(message = "The emer cannot be null or blank")
    private String emer;

    @Schema(example = "Right hand of solid 4 bladed keyless AEROFOIL")
    @NotBlank(message = "The propeller cannot be null or blank")
    private String propeller;

    @Schema(example = "INGOT FORGED (NK) - Area Ratio: 1/60 1 Balancing Ratio: 0.270")
    @NotBlank(message = "The rudder cannot be null or blank")
    private String rudder;

    @Schema(example = "Electro-Hydraulic Driven, Rapson-Slid")
    @NotBlank(message = "The steeringGear cannot be null or blank")
    private String steeringGear;

    @Schema(example = "Tubular Type, KM15, Cap 15t/day")
    @NotBlank(message = "The fwGeneratorCap cannot be null or blank")
    private String fwGeneratorCap;
}

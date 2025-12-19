package com.blychain.spocp.transferObject.documents.dangerousgoodsmanifest;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DangerousGoodsTO {
    @Schema(example = "ABC123")
    @NotBlank(message = "The marksAndNumbers cannot be null or blank")
    private String marksAndNumbers;

    @Schema(example = "SGP001")
    @NotBlank(message = "The freightContainerIdentification cannot be null or blank")
    private String freightContainerIdentification;

    @Schema(example = "SG-CAR001")
    @NotBlank(message = "The vehicleRegistrationNumbers cannot be null or blank")
    private String vehicleRegistrationNumbers;

    @Schema(example = "1203")
    @NotBlank(message = "The unNumber cannot be null or blank")
    private String unNumber;

    @Schema(example = "Gasoline")
    @NotBlank(message = "The properShippingName cannot be null or blank")
    private String properShippingName;

    @Schema(example = "Class 3")
    @JsonProperty("class")
    @NotBlank(message = "The class cannot be null or blank")
    private String dgClass;

    @Schema(example = "2")
    @NotBlank(message = "The packingGroup cannot be null or blank")
    private String packingGroup;

    @Schema(example = "Flash Point: 30°C")
    @NotBlank(message = "The additionalInformation cannot be null or blank")
    private String additionalInformation;

    @Schema(example = "10")
    @NotBlank(message = "The numberOfPackages cannot be null or blank")
    private String numberOfPackages;

    @Schema(example = "500 kg")
    @NotBlank(message = "The massOrVolume cannot be null or blank")
    private String massOrVolume;

    @Schema(example = "F-E")
    @NotBlank(message = "The ems cannot be null or blank")
    private String ems;
}

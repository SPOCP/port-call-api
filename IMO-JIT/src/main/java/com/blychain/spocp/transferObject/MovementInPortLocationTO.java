package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementInPortLocationTO {

    @Schema(example = "JNPT Terminal")
    @NotBlank(message = "The terminalName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .()/-]+$",
            message = "Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length cannot be more than 256")
    private String terminalName;


    //    Size Not Defined - IMO
    @Schema(example = "JNPT-01")
    @NotBlank(message = "The terminalCoded cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 256, message = "The length cannot be more than 256")
    private String terminalCoded;


    @Schema(example = "Mumbai Outer Anchorage")
    @NotBlank(message = "The pilotBoardingPlaceName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 256, message = "The length cannot be more than 256")
    private String pilotBoardingPlaceName;

    @Schema(example = "Berth 5")
    @NotBlank(message = "The berthName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 256, message = "The length cannot be more than 256")
    private String berthName;

    //    Size Not Defined - IMO
    @Schema(example = "BRT5")
    @NotBlank(message = "The berthCoded cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 256, message = "The length cannot be more than 256")
    private String berthCoded;

    @Schema(example = "West Quay")
    @NotBlank(message = "The berthPosition cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 256, message = "The length cannot be more than 256.")
    private String berthPosition;


    @Schema(example = "Mumbai Anchorage")
    @NotBlank(message = "The anchorageName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 256, message = "The length cannot be more than 256.")
    private String anchorageName;


    //    Size Not Defined - IMO
    @Schema(example = "ANC-MUM-01")
    @NotBlank(message = "The anchorageCoded cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9-]+$",
            message = "Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length cannot be more than 256.")
    private String anchorageCoded;


    @Valid
    private GeographicalPositionTO geographicalPosition;

}

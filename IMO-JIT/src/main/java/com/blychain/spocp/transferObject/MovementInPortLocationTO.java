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
    @NotBlank(message = "MovementInPortLocation - terminalName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .()/-]+$",
            message = "MovementInPortLocation - terminalName: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of MovementInPortLocation - terminalName cannot be more than 256.")
    private String terminalName;


    //    Size Not Defined - IMO
    @Schema(example = "JNPT-01")
    @NotBlank(message = "MovementInPortLocation - terminalCoded cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "MovementInPortLocation - terminalCoded: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of MovementInPortLocation - terminalCoded cannot be more than 256.")
    private String terminalCoded;


    @Schema(example = "Mumbai Outer Anchorage")
    @NotBlank(message = "MovementInPortLocation - pilotBoardingPlaceName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .()/-]+$",
            message = "MovementInPortLocation - pilotBoardingPlaceName: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of MovementInPortLocation - pilotBoardingPlaceName cannot be more than 256.")
    private String pilotBoardingPlaceName;

    @Schema(example = "Berth 5")
    @NotBlank(message = "MovementInPortLocation - berthName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .()/-]+$",
            message = "MovementInPortLocation - berthName: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of MovementInPortLocation - berthName cannot be more than 256.")
    private String berthName;

    //    Size Not Defined - IMO
    @Schema(example = "BRT5")
    @NotBlank(message = "MovementInPortLocation - berthCoded cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "MovementInPortLocation - berthCoded: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of MovementInPortLocation - berthCoded cannot be more than 256.")
    private String berthCoded;

    @Schema(example = "West Quay")
    @NotBlank(message = "MovementInPortLocation - berthPosition cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .()/-]+$",
            message = "MovementInPortLocation - berthPosition: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of MovementInPortLocation - berthPosition cannot be more than 256.")
    private String berthPosition;


    @Schema(example = "Mumbai Anchorage")
    @NotBlank(message = "MovementInPortLocation - anchorageName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .()/-]+$",
            message = "MovementInPortLocation - anchorageName: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of MovementInPortLocation - anchorageName cannot be more than 256.")
    private String anchorageName;


    //    Size Not Defined - IMO
    @Schema(example = "ANC-MUM-01")
    @NotBlank(message = "MovementInPortLocation - anchorageCoded cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "MovementInPortLocation - anchorageCoded: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of MovementInPortLocation - anchorageCoded cannot be more than 256.")
    private String anchorageCoded;


    @Valid
    private GeographicalPositionTO geographicalPosition;

}

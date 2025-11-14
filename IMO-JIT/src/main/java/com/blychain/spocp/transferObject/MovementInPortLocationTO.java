package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementInPortLocationTO {

    @Schema(example = "JNPT Terminal")
    @Size(max = 256, message = "The length of terminalName cannot be more than 256")
    private String terminalName;

    //    Size Not Defined - IMO
    @Size(max = 256, message = "The length of terminalCoded cannot be more than 256")
    @Schema(example = "JNPT-01")
    private String terminalCoded;

    @Schema(example = "Mumbai Outer Anchorage")
    @Size(max = 256, message = "The length of pilotBoardingPlaceName cannot be more than 256")
    private String pilotBoardingPlaceName;

    @Schema(example = "Berth 5")
    @Size(max = 256, message = "The length of berthName cannot be more than 256")
    private String berthName;

    //    Size Not Defined - IMO
    @Size(max = 256, message = "The length of berthCoded cannot be more than 256")
    @Schema(example = "BRT5")
    private String berthCoded;

    @Schema(example = "West Quay")
    @Size(max = 256, message = "The length of berthPosition cannot be more than 256")
    private String berthPosition;

    @Schema(example = "Mumbai Anchorage")
    @Size(max = 256, message = "The length of anchorageName cannot be more than 256")
    private String anchorageName;

    //    Size Not Defined - IMO
    @Size(max = 256, message = "The length of anchorageCoded cannot be more than 256")
    @Schema(example = "ANC-MUM-01")
    private String anchorageCoded;

    private GeographicalPositionTO geographicalPosition;

}

package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeographicalPositionTO {
    @Schema(example = "18.9633")
    @Size(max = 10, message = "The length of locationInPortLatitude cannot be more than 10")
    private String locationInPortLatitude;

    @Schema(example = "72.8358" )
    @Size(max = 11, message = "The length of locationInPortLongitude cannot be more than 11")
    private String locationInPortLongitude;
}

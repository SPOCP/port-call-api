package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeographicalPositionTO {

    @Schema(example = "18.9633")
    @NotBlank(message = "GeographicalPosition - locationInPortLatitude cannot be null.")
    @Pattern(
            regexp = "^[-+]?([1-8]?[0-9](\\.[0-9]+)?|90(\\.0+)?)$",
            message = "GeographicalPosition - locationInPortLatitude: Invalid value. Please check the field format."
    )
    @Size(max = 10, message = "The length of locationInPortLatitude cannot be more than 10.")
    private String locationInPortLatitude;


    @Schema(example = "72.8358")
    @NotBlank(message = "GeographicalPosition - locationInPortLongitude cannot be null.")
    @Pattern(
            regexp = "^[-+]?((1[0-7][0-9]|[1-9]?[0-9])(\\.[0-9]+)?|180(\\.0+)?)$",
            message = "GeographicalPosition - locationInPortLongitude: Invalid value. Please check the field format."
    )
    @Size(max = 11, message = "The length of locationInPortLongitude cannot be more than 11.")
    private String locationInPortLongitude;


}

package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipTO {

    @Schema(example = "9V1234")
    @NotBlank(message = "The shipCallSign cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 7, message = "The length cannot be more than 7")
    private String shipCallSign;

    @Schema(example = "9312345")
    @NotBlank(message = "The shipIMONumber cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 7, message = "The length cannot be more than 7")
    private String shipIMONumber;

    @Schema(example = "419001234")
    @NotNull(message = "The shipMMSINumber cannot be null")
    @Min(value = 100000000, message = "Invalid value. Please check the field format")
    @Max(value = 999999999, message = "Invalid value. Please check the field format")
    private Integer shipMMSINumber;

    @Schema(example = "MV Blue Horizon")
    @NotBlank(message = "The shipName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .,&()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 70, message = "The length cannot be more than 70")
    private String shipName;

}

package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipTO {

    @Schema(example = "9V1234")
    @Size(max = 7, message = "The length of shipCallSign cannot be more than 7")
    private String shipCallSign;

    @Schema(example = "9312345")
    @Size(max = 7, message = "The length of shipIMONumber cannot be more than 7")
    private String shipIMONumber;

    @Schema(example = "419001234")
    @Min(value = 100000000, message = "The shipMMSINumber must be exactly 9 digits long")
    @Max(value = 999999999, message = "The shipMMSINumber must be exactly 9 digits long")
    @Positive(message = "The shipMMSINumber must be positive")
    private Integer shipMMSINumber;

    @Schema(example = "MV Blue Horizon")
    @Size(max = 70, message = "The length of shipName cannot be more than 70")
    private String shipName;

}

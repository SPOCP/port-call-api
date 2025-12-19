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
    @NotBlank(message = "Ship - shipCallSign cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "Ship - shipCallSign: Invalid value. Please check the field format."
    )
    @Size(max = 7, message = "The length of Ship - shipCallSign cannot be more than 7.")
    private String shipCallSign;

    @Schema(example = "9312345")
    @NotBlank(message = "Ship - shipIMONumber cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "Ship - shipIMONumber: Invalid value. Please check the field format."
    )
    @Size(max = 7, message = "The length of Ship - shipIMONumber cannot be more than 7.")
    private String shipIMONumber;

    @Schema(example = "419001234")
    @NotNull(message = "Ship - shipMMSINumber cannot be null.")
    @Min(value = 100000000, message = "Ship - shipMMSINumber: Invalid value. Please check the field format.")
    @Max(value = 999999999, message = "Ship - shipMMSINumber: Invalid value. Please check the field format.")
    private Integer shipMMSINumber;

    @Schema(example = "MV Blue Horizon")
    @NotBlank(message = "Ship - shipName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .,&()/-]+$",
            message = "Ship - shipName: Invalid value. Please check the field format."
    )
    @Size(max = 70, message = "The length of Ship - shipName cannot be more than 70.")
    private String shipName;

}

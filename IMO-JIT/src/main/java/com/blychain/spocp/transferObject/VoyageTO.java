package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoyageTO {

    @Schema(example = "VN20250612-MUMDXB")
    @NotBlank(message = "The voyageNumber cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 17, message = "The length cannot be more than 17")
    private String voyageNumber;


    @Schema(example = "TIS-444115")
    @NotBlank(message = "The tradeServiceIdentifier cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 17, message = "The length cannot be more than 17")
    private String tradeServiceIdentifier;

    @Valid
    private List<PortCallTO> portCall;

    @Valid
    private List<ItineraryTO> itinerary;

    @Valid
    private ShipTO ship;
}

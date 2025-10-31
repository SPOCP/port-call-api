package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoyageTO {

    @NotBlank(message = "Voyage - voyageNumber cannot be Null")
    @Schema(example = "VN20250612-MUMDXB")
    @Size(max = 17, message = "The length of voyageNumber cannot be more than 17")
    private String voyageNumber;

    @Schema(example = "TIS-444115")
    @Size(max = 17, message = "The length of tradeIdentifierService cannot be more than 17")
    private String tradeIdentifierService;


    @Valid
    private List<PortCallTO> portCall;

    @Valid
    private List<ItineraryTO> itinerary;

    @Valid
    private ShipTO ship;
}

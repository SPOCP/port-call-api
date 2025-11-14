package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortCallTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long portCallId;

    @Schema(example = "INNSA-NSICT")
    @Size(max = 17, message = "The length of portFacilityCoded cannot be more than 17")
    private String portFacilityCoded;

    @Schema(example = "Nhava Sheva International Container Terminal (NSICT)")
    @Size(max = 256, message = "The length of portFacilityName cannot be more than 256")
    private String portFacilityName;

    @Schema(example = "SSRN-INNSA-20250210-001")
    @Size(max = 35, message = "The length of shipStayReferenceNumber cannot be more than 35")
    private String shipStayReferenceNumber;

    private OffsetDateTime dateAndTimeOfDepartureActual;

    private OffsetDateTime dateAndTimeOfDepartureEstimated;

    private OffsetDateTime dateAndTimeOfDeparturePlanned;

    private OffsetDateTime dateAndTimeOfDepartureRequested;

    @Schema(example = "SGSIN")
    @Pattern(regexp = "^[A-Za-z0-9]{5}$", message = "The portOfDepartureCoded must have 5 alphanumeric characters")
//    @Size(max = 5, message = "The length of portOfDepartureCoded cannot be more than 5")
    private String portOfDepartureCoded;

    @Schema(example = "Port of Singapore")
    @Size(max = 256, message = "The length of portOfDepartureName cannot be more than 256")
    private String portOfDepartureName;

    private OffsetDateTime dateAndTimeOfArrivalActual;

    private OffsetDateTime dateAndTimeOfArrivalEstimated;

    private OffsetDateTime dateAndTimeOfArrivalPlanned;

    private OffsetDateTime dateAndTimeOfArrivalRequested;

    //    @Size(max = 5, message = "The length of portOfArrivalCoded cannot be more than 5")

    @Schema(example = "INNSA")
    @Pattern(regexp = "^[A-Za-z0-9]{5}$", message = "The portOfDepartureCoded must have 5 alphanumeric characters")
    private String portOfArrivalCoded;

    @Schema(example = "Nhava Sheva (JNPT), India")
    @Size(max = 256, message = "The length of portOfArrivalName cannot be more than 256")
    private String portOfArrivalName;

    @Valid
    private AgentAtPortTO agentAtPort;

    @Valid
    private PrimaryPurposesOfCallTO primaryPurposesOfCall;

    @Valid
    private List<MovementInPortTO> movementInPort;

    @Valid
    private List<MaritimeServiceTO> maritimeService;

}

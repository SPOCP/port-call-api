package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "PortCall - portFacilityCoded cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .,&()/-]+$",
            message = "PortCall - portFacilityCoded: Invalid value. Please check the field format."
    )
    @Size(max = 17, message = "The length of PortCall - portFacilityCoded cannot be more than 17")
    private String portFacilityCoded;


    @Schema(example = "Nhava Sheva International Container Terminal")
    @NotBlank(message = "PortCall - portFacilityName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .,&()/-]+$",
            message = "PortCall - portFacilityName: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of PortCall - portFacilityName cannot be more than 256.")
    private String portFacilityName;


    @Schema(example = "SSRN-INNSA-20250210-001")
    @NotBlank(message = "PortCall - shipStayReferenceNumber cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .,&()/-]+$",
            message = "PortCall - shipStayReferenceNumber: Invalid value. Please check the field format."
    )
    @Size(max = 35, message = "The length of PortCall - shipStayReferenceNumber cannot be more than 35.")
    private String shipStayReferenceNumber;


    @NotNull(message = "PortCall - dateAndTimeOfDepartureActual cannot be null.")
    private OffsetDateTime dateAndTimeOfDepartureActual;

    @NotNull(message = "PortCall - dateAndTimeOfDepartureEstimated cannot be null.")
    private OffsetDateTime dateAndTimeOfDepartureEstimated;

    @NotNull(message = "PortCall - dateAndTimeOfDeparturePlanned cannot be null.")
    private OffsetDateTime dateAndTimeOfDeparturePlanned;

    @NotNull(message = "PortCall - dateAndTimeOfDepartureRequested cannot be null.")
    private OffsetDateTime dateAndTimeOfDepartureRequested;

    @Schema(example = "SGSIN")
    @NotBlank(message = "PortCall - portOfDepartureCoded cannot be null.")
    @Pattern(
            regexp = "^[A-Z]{5}$",
            message = "PortCall - portOfDepartureCode must be exactly 5 uppercase alphanumeric characters."
    )
    @Size(min = 5,max = 5,message = "PortCall - portOfDepartureCoded should have a length 5")
    private String portOfDepartureCoded;


    @Schema(example = "Port of Singapore")
    @NotBlank(message = "PortCall - portOfDepartureName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .,&()/-]+$",
            message = "PortCall - portOfDepartureName: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of PortCall - portOfDepartureName cannot be more than 256.")
    private String portOfDepartureName;


    @NotNull(message = "PortCall - dateAndTimeOfArrivalActual cannot be null.")
    private OffsetDateTime dateAndTimeOfArrivalActual;

    @NotNull(message = "PortCall - dateAndTimeOfArrivalEstimated cannot be null.")
    private OffsetDateTime dateAndTimeOfArrivalEstimated;

    @NotNull(message = "PortCall - dateAndTimeOfArrivalPlanned cannot be null.")
    private OffsetDateTime dateAndTimeOfArrivalPlanned;

    @NotNull(message = "PortCall - dateAndTimeOfArrivalRequested cannot be null.")
    private OffsetDateTime dateAndTimeOfArrivalRequested;

    @Schema(example = "INNSA")
    @NotBlank(message = "PortCall - portOfArrivalCoded cannot be null.")
//    @Pattern(
//            regexp = "^[A-Za-z0-9]$",
//            message = "PortCall - portOfArrivalCoded: Invalid value. Please check the field format."
//    )
//    @Size(min = 5,max = 5,message = "PortCall - portOfArrivalCoded should have a length 5")
    @Pattern(
            regexp = "^[A-Z]{5}$",
            message = "PortCall - portOfDepartureCode must be exactly 5 uppercase alphanumeric characters."
    )
    private String portOfArrivalCoded;


    @Schema(example = "Nhava Sheva JNPT, India")
    @NotBlank(message = "PortCall - portOfArrivalName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .,&()/-]+$",
            message = "PortCall - portOfArrivalName: Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length of PortCall - portOfArrivalName cannot be more than 256.")
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

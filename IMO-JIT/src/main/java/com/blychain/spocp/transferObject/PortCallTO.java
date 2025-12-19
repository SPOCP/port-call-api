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
    @NotBlank(message = "The portFacilityCoded cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .,&()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 17, message = "The length cannot be more than 17")
    private String portFacilityCoded;


    @Schema(example = "Nhava Sheva International Container Terminal")
    @NotBlank(message = "The portFacilityName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .,&()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 256, message = "The length cannot be more than 256")
    private String portFacilityName;


    @Schema(example = "SSRN-INNSA-20250210-001")
    @NotBlank(message = "The shipStayReferenceNumber cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .,&()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 35, message = "The length cannot be more than 35")
    private String shipStayReferenceNumber;


    @NotNull(message = "The dateAndTimeOfDepartureActual cannot be null")
    private OffsetDateTime dateAndTimeOfDepartureActual;

    @NotNull(message = "The dateAndTimeOfDepartureEstimated cannot be null")
    private OffsetDateTime dateAndTimeOfDepartureEstimated;

    @NotNull(message = "The dateAndTimeOfDeparturePlanned cannot be null")
    private OffsetDateTime dateAndTimeOfDeparturePlanned;

    @NotNull(message = "The dateAndTimeOfDepartureRequested cannot be null")
    private OffsetDateTime dateAndTimeOfDepartureRequested;

    @Schema(example = "SGSIN")
    @NotBlank(message = "The portOfDepartureCoded cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Z]{5}$",
            message = "It must be exactly 5 uppercase alphanumeric characters"
    )
    @Size(min = 5,max = 5,message = "The portOfDepartureCoded should have a length 5")
    private String portOfDepartureCoded;


    @Schema(example = "Port of Singapore")
    @NotBlank(message = "The portOfDepartureName cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .,&()/-]+$",
            message = "Invalid value. Please check the field format"
    )
    @Size(max = 256, message = "The length cannot be more than 256")
    private String portOfDepartureName;


    @NotNull(message = "The dateAndTimeOfArrivalActual cannot be null")
    private OffsetDateTime dateAndTimeOfArrivalActual;

    @NotNull(message = "The dateAndTimeOfArrivalEstimated cannot be null")
    private OffsetDateTime dateAndTimeOfArrivalEstimated;

    @NotNull(message = "The dateAndTimeOfArrivalPlanned cannot be null")
    private OffsetDateTime dateAndTimeOfArrivalPlanned;

        @NotNull(message = "The dateAndTimeOfArrivalRequested cannot be null")
    private OffsetDateTime dateAndTimeOfArrivalRequested;

    @Schema(example = "INNSA")
    @NotBlank(message = "The portOfArrivalCoded cannot be null or blank")
    @Pattern(
            regexp = "^$|^[A-Z]{5}$",
            message = "It must be exactly 5 uppercase alphanumeric characters."
    )
    private String portOfArrivalCoded;


    @Schema(example = "Nhava Sheva JNPT, India")
    @NotBlank(message = "The portOfArrivalName cannot be null or blank.")
    @Pattern(
            regexp = "^$|^[A-Za-z0-9 .,&()/-]+$",
            message = "Invalid value. Please check the field format."
    )
    @Size(max = 256, message = "The length cannot be more than 256.")
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

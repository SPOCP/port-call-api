package com.blychain.spocp.transferObject.documents.generaldeclaration;

import com.blychain.spocp.transferObject.documents.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GDVoyageInformationTO {

    @Schema(example = "Ocean Voyager")
    @NotBlank(message = "The nameOfShip cannot be null or blank")
    private String nameOfShip;

    @Schema(example = "Container Ship")
    @NotBlank(message = "The typeOfShip cannot be null or blank")
    private String typeOfShip;

    @Schema(example = "IMO9876543")
    @NotBlank(message = "The imoNumber cannot be null or blank")
    private String imoNumber;

    @Schema(example = "VTAB")
    @NotBlank(message = "The callSign cannot be null or blank")
    private String callSign;

    @Schema(example = "OV-IND-0224")
    @NotBlank(message = "The voyageNumber cannot be null or blank")
    private String voyageNumber;

    @Schema(example = "1500")
    @NotNull(message = "The netTonnage cannot be null")
    private Double netTonnage;

    @Schema(example = "2000")
    @NotNull(message = "The grossTonnage cannot be null")
    private Double grossTonnage;

    @Schema(example = "India")
    @NotBlank(message = "The flagState cannot be null or blank")
    private String flagState;

    @Schema(example = "20")
    @NotNull(message = "The numberOfCrew cannot be null")
    private Integer numberOfCrew;

    @Schema(example = "12")
    @NotNull(message = "The numberOfPassengers cannot be null")
    private Integer numberOfPassengers;

    @Schema(example = "Containerized cargo consisting of engineering goods, electronics, and consumer products.")
    @NotBlank(message = "The briefDescriptionOfTheCargo cannot be null or blank")
    private String briefDescriptionOfTheCargo;

    @Schema(example = "Jawaharlal Nehru Port, Mumbai")
    @NotBlank(message = "The currentPort cannot be null or blank")
    private String currentPort;

    @Schema(example = "Vessel arrived safely and is awaiting berth allocation.")
    @NotBlank(message = "The remark cannot be null or blank")
    private String remark;

    @Schema(example = "Garbage disposal and oily waste reception facilities required.")
    @NotNull(message = "The shipRequirements cannot be null")
    private String shipRequirements;

    @Valid
    @NotNull(message = "The masterContact cannot be null")
    private MasterContactTO masterContact;

    @Valid
    @NotNull(message = "The agentContact cannot be null")
    private AgentContactTO agentContact;

    @Valid
    @NotNull(message = "The certificateOfRegistry cannot be null")
    private CertificateOfRegistryTO certificateOfRegistry;

    @NotNull(message = "The dateAndTimeOfArrival cannot be null")
    private DateAndTimeTO dateAndTimeOfArrival;

    @Valid
    @NotNull(message = "The dateAndTimeOfDeparture cannot be null")
    private DateAndTimeTO dateAndTimeOfDeparture;

    @Schema(example = "[Cargo Declaration,Ship's Stores Declaration,Crew List]")
    @NotEmpty(message = "The attachedDocuments cannot be empty")
    private List<String> attachedDocuments;

    @Valid
    @NotEmpty(message = "The voyagePortCalls cannot be empty")
    private List<VoyagePortCallTO> voyagePortCalls;
}

package com.blychain.spocp.transferObject.documents.crewlist;

import com.blychain.spocp.transferObject.documents.DateAndTimeTO;
import com.blychain.spocp.transferObject.documents.VoyagePortCallTO;
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
public class CLVoyageInformationTO {

    @Schema(example = "Ocean Voyager")
    @NotBlank(message = "The nameOfShip cannot be null or blank")
    private String nameOfShip;

    @Schema(example = "IMO9876543")
    @NotBlank(message = "The imoNumber cannot be null or blank")
    private String imoNumber;

    @Schema(example = "VTAB")
    @NotBlank(message = "The callSign cannot be null or blank")
    private String callSign;

    @Schema(example = "OV-IND-0224")
    @NotBlank(message = "The voyageNumber cannot be null or blank")
    private String voyageNumber;

    @Schema(example = "India")
    @NotBlank(message = "The flagState cannot be null or blank")
    private String flagState;

    @Schema(example = "Jawaharlal Nehru Port, Mumbai")
    @NotBlank(message = "The currentPort cannot be null or blank")
    private String currentPort;

    @Schema(example = "120")
    @NotNull(message = "The numberOfPersonsOnBoard cannot be null or blank")
    private Integer numberOfPersonsOnBoard;

    @Schema(example = "7 Days")
    @NotBlank(message = "The periodOfStay cannot be null or blank")
    private String periodOfStay;

    @Valid
    @NotNull(message = "The dateAndTimeOfArrival cannot be null")
    private DateAndTimeTO dateAndTimeOfArrival;

    @Valid
    @NotNull(message = "The dateAndTimeOfDeparture cannot be null")
    private DateAndTimeTO dateAndTimeOfDeparture;

    @Valid
    @NotEmpty(message = "The voyagePortCalls cannot be empty")
    private List<VoyagePortCallTO> voyagePortCalls;


}

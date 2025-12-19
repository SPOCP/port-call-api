package com.blychain.spocp.transferObject.documents.shipsparticulars;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipsParticularsTO {

    @Schema(example = "M/V")
    @NotBlank(message = "The type cannot be null or blank")
    private String type;

    @Schema(example = "Trident Star")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "57836")
    @NotNull(message = "The deadweightTonnage cannot be null or blank")
    private Integer deadweightTonnage;

    @Schema(example = "Bulk Carrier")
    @NotBlank(message = "The vesselType cannot be null or blank")
    private String vesselType;

    @Schema(example = "2015-01-12")
    @NotNull(message = "The keelLaid cannot be null")
    private LocalDate keelLaid;

    @Schema(example = "2015-01-12")
    @NotNull(message = "The launched cannot be null")
    private LocalDate launched;

    @Schema(example = "2015-01-12")
    @NotNull(message = "The delivered cannot be null")
    private LocalDate delivered;

    @Schema(example = "TSUNEISHI HEAVY INDUSTRIES (CEBU), INC.")
    @NotBlank(message = "The shipYardLine1 cannot be null or blank")
    private String shipYardLine1;

    @Valid
    @NotNull(message = "The principalDimensions cannot be null")
    private PrincipalDimensionsTO principalDimensions;

    @Valid
    @NotNull(message = "The loadLineInformation cannot be null")
    private LoadLineInformationTO loadLineInformation;

    @Valid
    @NotNull(message = "The tankCapacities cannot be null")
    private TankCapacitiesTO tankCapacities;

    @Valid
    @NotNull(message = "The ballastTank cannot be null")
    private BallastTankTO ballastTank;

    @Valid
    @NotNull(message = "The lumbarOrLogCapacity cannot be null")
    private LumbarOrLogCapacityTO lumbarOrLogCapacity;

    @Schema(example = "[9.5,11.5]")
    @NotEmpty(message = "The deckStanchionHeight cannot be empty")
    private List<Double> deckStanchionHeight;

    @Valid
    @NotNull(message = "The machineryOrPropellerOrRudder cannot be null")
    private MachineryOrPropellerOrRudderTO machineryOrPropellerOrRudder;

    @Valid
    @NotEmpty(message = "The hfoTanks cannot be empty")
    private List<HfoTankTO> hfoTanks;

    @Schema(example = "1821.6")
    @NotNull(message = "The hfoTotal cannot be null")
    private Double hfoTotal;

    @Valid
    @NotEmpty(message = "The mdoTanks cannot be empty")
    private List<MdoTankTO> mdoTanks;

    @Valid
    @NotNull(message = "The winchesOrwindlassOrRopesOrEmergencyTowing cannot be null")
    private WinchesOrWindlassOrRopesOrEmergencyTowingTO winchesOrwindlassOrRopesOrEmergencyTowing;

    @Valid
    @NotEmpty(message = "The fwTank cannot be empty")
    private List<FwTankTO> fwTank;

    @Schema(example = "312")
    @NotNull(message = "The fwTankTotal cannot be null")
    private Double fwTankTotal;

    @Valid
    @NotNull(message = "The cargoAndBallastPumpingSystem cannot be null")
    private CargoAndBallastPumpingSystemTO cargoAndBallastPumpingSystem;

    @Schema(example = "IHI Electro-Hydraulic Driven x 4 sets SWL 30 mt, 24 mt")
    @NotBlank(message = "The deckCranes cannot be null or blank")
    private String deckCranes;

    @Valid
    @NotNull(message = "The distanceWLcoaming cannot be null")
    private DistanceWLcoamingTO distanceWLcoaming;

    @Valid
    @NotNull(message = "The lifeBoat cannot be null")
    private BoatTO lifeBoat;

    @Valid
    @NotNull(message = "The rescueBoat cannot be null")
    private BoatTO rescueBoat;

    @Valid
    @NotNull(message = "The lifeRafts cannot be null")
    private LifeRaftsTO lifeRafts;

    @Valid
    @JsonProperty("LRaftHandlingDavit")
    @NotNull(message = "The LRaftHandlingDavit cannot be null")
    private LRaftHandlingDavitTO LRaftHandlingDavit;

    @Schema(example = "2.5 kts")
    @NotBlank(message = "The minBowDrft cannot be null or blank")
    private String minBowDrft;

    @Schema(example = "149 %")
    @NotBlank(message = "The propellerImmer cannot be null or blank")
    private String propellerImmer;

    @Schema(example = "700 mm")
    @NotBlank(message = "The cementHoleDia cannot be null or blank")
    private String cementHoleDia;

    @Schema(example = "Fire doors, deck and bulkhead")
    @NotBlank(message = "The a60 cannot be null or blank")
    private String a60;

    @Valid
    @NotNull(message = "The hatchCoverSize cannot be null")
    private HatchCoverSizeTO hatchCoverSize;

    @Valid
    @NotNull(message = "The otherDetails cannot be null")
    private OtherDetailsTO otherDetails;

    @Schema(example = "Frame 3,5: 25.1 t/m², Frame 2,4: 18.3 t/m²")
    @NotBlank(message = "The tanktopStength cannot be null or blank")
    private String tanktopStength;

    @Schema(example = "H1-5 4.0t/m2")
    @NotBlank(message = "The hatchCoverStrength cannot be null or blank")
    private String hatchCoverStrength;

    @Schema(example = "3.50 t/m2")
    @NotBlank(message = "The upperDeckStrength cannot be null or blank")
    private String upperDeckStrength;

    @Valid
    @NotNull(message = "The tanktopDimensions cannot be null")
    private TanktopDimensionsTO tanktopDimensions;

    @Valid
    @NotNull(message = "The fireFightingSystem cannot be null")
    private FireFightingSystemTO fireFightingSystem;
}

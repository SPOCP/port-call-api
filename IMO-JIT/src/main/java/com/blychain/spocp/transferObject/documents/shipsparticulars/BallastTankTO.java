package com.blychain.spocp.transferObject.documents.shipsparticulars;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
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
public class BallastTankTO {
    @Schema(example = "1683.4")
    @NotNull(message = "The shipYardLine1 cannot be null")
    private Double fpt;

    @Schema(example = "661")
    @NotNull(message = "The apt cannot be null")
    private Double apt;

    @Schema(example = "15343.10")
    @NotNull(message = "The ch3 cannot be null")
    private Double ch3;

    @Schema(example = "31553.90")
    @NotNull(message = "The bTotal cannot be null")
    @JsonProperty("bTotal")
    private Double bTotal;

    @Valid
    @NotNull(message = "The dbtList cannot be null or blank")
    private List<DbtTO> dbtList;

    @Valid
    @NotEmpty(message = "The swbtList cannot be empty")
    private List<SwbtTO> swbtList;
}

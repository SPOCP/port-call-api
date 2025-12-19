package com.blychain.spocp.transferObject.documents.shipsparticulars;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WinchesOrWindlassOrRopesOrEmergencyTowingTO {
    @Valid
    @NotNull(message = "The winches cannot be null")
    private WinchesTO winches;

    @Valid
    @NotNull(message = "The windclass cannot be null")
    private WindclassTO windclass;

    @Valid
    @NotNull(message = "The anchor cannot be null")
    private AnchorTO anchor;

    @Valid
    @NotNull(message = "The emergencyTowing cannot be null")
    private EmergencyTowingTO emergencyTowing;
}

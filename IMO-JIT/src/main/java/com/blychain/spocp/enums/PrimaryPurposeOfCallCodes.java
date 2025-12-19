package com.blychain.spocp.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum PrimaryPurposeOfCallCodes {
    CARGO_OPERATIONS("1", "Cargo operations", "Discharging and/or loading of cargo"),
    PASSENGER_MOVEMENT("2", "Passenger movement", "Embarking and/or disembarking of passengers"),
    TAKING_BUNKERS("3", "Taking bunkers", "Taking bunker (refuelling)"),
    CHANGING_CREW("4", "Changing crew", "Changing crew member(s)"),
    GOODWILL_VISIT("5", "Goodwill visit", "Friendly visit"),
    TAKING_SUPPLIES("6", "Taking supplies", "Taking supplies"),
    REPAIR("7", "Repair", "To effect repair"),
    LAID_UP("8", "Laid-up", "Inactive service"),
    AWAITING_ORDERS("9", "Awaiting orders", "Awaiting job order"),
    MISCELLANEOUS("10", "Miscellaneous", "Miscellaneous purpose of call"),
    CREW_MOVEMENT("11", "Crew movement", "Embarking and/or disembarking of crews"),
    CRUISE_LEISURE("12", "Cruise, leisure and recreation", "To visit a port for cruise, leisure and recreation"),
    UNDER_GOVT_ORDER("13", "Under government order", "Visit ordered by government"),
    QUARANTINE_INSPECTION("14", "Quarantine inspection", "To have a quarantine inspection"),
    REFUGE("15", "Refuge", "To seek protection against bad weather or danger"),
    UNLOADING_CARGO("16", "Unloading cargo", "Discharging of cargo"),
    LOADING_CARGO("17", "Loading cargo", "Loading of cargo"),
    REPAIR_DRY_DOCK("18", "Repair in dry dock", "Vessel to undergo repair in a dry dock"),
    REPAIR_WET_DOCK("19", "Repair in wet dock", "Repair of a vessel in dock without removing water"),
    CARGO_TANK_CLEANING("20", "Cargo tank cleaning", "Cargo tanks will be cleaned"),
    CUSTOMS_CLEARANCE("21", "Means of transport customs clearance", "Means of transport will be customs cleared"),
    DE_GASSING("22", "De-gassing", "Means of transport will be de-gassed"),
    WASTE_DISPOSAL("23", "Waste disposal", "Dispose of waste"),
    OFFSHORE_OPERATIONS("24", "Offshore mobilization operations", "Preparing vessel for offshore operations"),
    TRANSFER_OF_PERSONNEL("25", "Transfer of personnel", "Transfer of personnel from or to a means of transport"),
    PASS_THROUGH("98", "Pass through", "Means of transport will pass through only");

    private final String code;
    private final String codeName;
    private final String description;


    public static boolean isValid(String code) {
        if (code == null) return false;
        return Arrays.stream(values()).anyMatch(v -> Objects.equals(v.code, code));
    }

}

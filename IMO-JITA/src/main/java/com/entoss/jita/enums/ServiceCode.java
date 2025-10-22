package com.entoss.jita.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServiceCode {

    ANCO("Anchorage operations", "Nautical service"),
    BBGO("Break Bulk cargo operations", "Cargo operation service"),
    BUNK("Bunkers", "Ship service"),
    CASV("Cargo Survey", "Statutory"),
    CGHF("Cargo handling facilities", "Cargo operation service"),
    CLSV("Class Surveys", "Statutory"),
    CONV("Convoy", "Nautical service"),
    CRGO("Container cargo operations", "Cargo operation service"),
    CRNS("Cranes", "Cargo operation service"),
    CSTM("Customs", "Statutory"),
    DGAU("Degaussing", "Nautical service"),
    DIVG("Diving", "Ship service"),
    DRSV("Draught Survey", "Statutory"),
    EMCY("Emergency", "Safety/Security"),
    ESCO("Escorting", "Nautical service"),
    FAST("Vessel 'all fast'", "Safety/Security"),
    FUMI("Fumigation", "Ship service"),
    GAGR("Cargo gear", "Cargo operation service"),
    GWAY("Gangway down and secure", "Safety/Security"),
    HLTH("Port health", "Statutory"),
    HOSE("Hoses", "Cargo operation service"),
    ICEN("Ice Navigation", "Nautical service"),
    IMGT("Immigration", "Statutory"),
    INSV("Insurance Survey", "Statutory"),
    IOPS("Ice breaking", "Nautical service"),
    LASH("Lashing", "Cargo operation service"),
    LUBE("Lube Oil", "Ship service"),
    MOOR("Lines", "Nautical service"),
    PILO("Pilotage", "Nautical service"),
    POTW("Potable Water", "Ship service"),
    PROV("Provisions", "Ship service"),
    REPR("Repair/service", "Ship service"),
    RESV("Representative survey", "Statutory"),
    SAFE("Safety", "Safety/Security"),
    SECR("Security", "Safety/Security"),
    SHPW("Shore power", "Ship service"),
    SLOP("Slop Disposal", "Ship service"),
    SLUG("Sludge", "Ship service"),
    SPRE("Spares deliveries", "Ship service"),
    STDS("Stevedores", "Cargo operation service"),
    STRS("Store", "Ship service"),
    TOWG("Towage/Tugs", "Nautical service"),
    TRSH("Trash Disposal", "Ship service"),
    VRDY("Vessel ready", "Safety/Security"),
    VTNG("Vetting", "Statutory"),
    VTS("VTS", "Nautical service");

    private final String name;
    private final String description;

}

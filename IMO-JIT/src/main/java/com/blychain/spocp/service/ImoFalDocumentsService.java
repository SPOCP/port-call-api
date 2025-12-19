package com.blychain.spocp.service;

import com.blychain.spocp.transferObject.documents.cargodeclaration.CargoDeclarationTO;
import com.blychain.spocp.transferObject.documents.crewlist.CrewListTO;
import com.blychain.spocp.transferObject.documents.crewseffectsdeclaration.CrewsEffectsDeclarationTO;
import com.blychain.spocp.transferObject.documents.dangerousgoodsmanifest.DangerousGoodsManifestTO;
import com.blychain.spocp.transferObject.documents.generaldeclaration.GeneralDeclarationTO;
import com.blychain.spocp.transferObject.documents.passengerlist.PassengerListTO;
import com.blychain.spocp.transferObject.documents.shipsparticulars.ShipsDetailsTO;
import com.blychain.spocp.transferObject.documents.shipsstore.ShipsStoreDeclarationTO;
import org.springframework.http.ResponseEntity;

public interface ImoFalDocumentsService {

    //    GENERAL DECLARATION
    ResponseEntity<?> createGeneralDeclaration(GeneralDeclarationTO payload);

    //    CARGO DECLARATION
    ResponseEntity<?> createCargoDeclaration(CargoDeclarationTO payload);

    //    SHIP STORES DECLARATION
    ResponseEntity<?> createShipsStoreDeclaration(ShipsStoreDeclarationTO payload);

    //    CREW EFFECTS DECLARATION
    ResponseEntity<?> createCrewsEffectsDeclaration(CrewsEffectsDeclarationTO payload);

    //    CREW LIST
    ResponseEntity<?> createCrewList(CrewListTO payload);

    //    PASSENGER LIST
    ResponseEntity<?> createPassengerList(PassengerListTO payload);

    //    DANGEROUS GOODS MANIFEST
    ResponseEntity<?> createDangerousGoodsManifest(DangerousGoodsManifestTO payload);

    //    SHIP PARTICULARS
    ResponseEntity<?> createShipsParticulars(ShipsDetailsTO payload);

    //    GET DOCUMENT
    ResponseEntity<byte[]> getDocument(String pdfName);

}

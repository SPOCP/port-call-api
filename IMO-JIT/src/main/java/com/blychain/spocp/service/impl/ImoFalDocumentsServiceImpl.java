package com.blychain.spocp.service.impl;

import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.service.ImoFalDocumentsService;
import com.blychain.spocp.service.PdfGenerationService;
import com.blychain.spocp.transferObject.CustomPdfResponseTO;
import com.blychain.spocp.transferObject.PdfResponseTO;
import com.blychain.spocp.transferObject.documents.cargodeclaration.CargoDeclarationTO;
import com.blychain.spocp.transferObject.documents.crewlist.CrewListTO;
import com.blychain.spocp.transferObject.documents.crewseffectsdeclaration.CrewsEffectsDeclarationTO;
import com.blychain.spocp.transferObject.documents.dangerousgoodsmanifest.DangerousGoodsManifestTO;
import com.blychain.spocp.transferObject.documents.generaldeclaration.GeneralDeclarationTO;
import com.blychain.spocp.transferObject.documents.passengerlist.PassengerListTO;
import com.blychain.spocp.transferObject.documents.shipsparticulars.ShipsDetailsTO;
import com.blychain.spocp.transferObject.documents.shipsstore.ShipsStoreDeclarationTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ImoFalDocumentsServiceImpl implements ImoFalDocumentsService {

    //    Service
    private final PdfGenerationService pdfGenerationService;

    //    GENERAL DECLARATION
    @Override
    public ResponseEntity<?> createGeneralDeclaration(GeneralDeclarationTO payload) {
        String pdfName = "IMO_GeneralDeclaration" + "_" + Instant.now().toEpochMilli() + ".pdf";
        String templateName = "IMO_GeneralDeclaration";

        ResponseEntity<PdfResponseTO> pdfResponseResponseEntity = pdfGenerationService.generatePdf(pdfName, templateName, payload);

        PdfResponseTO body = pdfResponseResponseEntity.getBody();

        if (pdfResponseResponseEntity.getStatusCode().is2xxSuccessful() && body != null) {
            return customPdfResponse(body);
        }

        return pdfResponseResponseEntity;

    }

    //    CARGO DECLARATION
    @Override
    public ResponseEntity<?> createCargoDeclaration(CargoDeclarationTO payload) {
        String pdfName = "IMO_CargoDeclaration" + "_" + Instant.now().toEpochMilli() + ".pdf";
        String templateName = "IMO_CargoDeclaration";

        ResponseEntity<PdfResponseTO> pdfResponseResponseEntity = pdfGenerationService.generatePdf(pdfName, templateName, payload);

        PdfResponseTO body = pdfResponseResponseEntity.getBody();

        if (pdfResponseResponseEntity.getStatusCode().is2xxSuccessful() && body != null) {
            return customPdfResponse(body);
        }

        return pdfResponseResponseEntity;
    }

    //    SHIP STORES
    @Override
    public ResponseEntity<?> createShipsStoreDeclaration(ShipsStoreDeclarationTO payload) {
        String pdfName = "IMO_ShipsStoreDeclaration" + "_" + Instant.now().toEpochMilli() + ".pdf";
        String templateName = "IMO_ShipsStoreDeclaration";

        ResponseEntity<PdfResponseTO> pdfResponseResponseEntity = pdfGenerationService.generatePdf(pdfName, templateName, payload);

        PdfResponseTO body = pdfResponseResponseEntity.getBody();

        if (pdfResponseResponseEntity.getStatusCode().is2xxSuccessful() && body != null) {
            return customPdfResponse(body);
        }

        return pdfResponseResponseEntity;
    }

    //    CREW EFFECTS DECLARATION
    @Override
    public ResponseEntity<?> createCrewsEffectsDeclaration(CrewsEffectsDeclarationTO payload) {
        String pdfName = "IMO_CrewsEffectsDeclaration" + "_" + Instant.now().toEpochMilli() + ".pdf";
        String templateName = "IMO_CrewsEffectsDeclaration";

        ResponseEntity<PdfResponseTO> pdfResponseResponseEntity = pdfGenerationService.generatePdf(pdfName, templateName, payload);

        PdfResponseTO body = pdfResponseResponseEntity.getBody();

        if (pdfResponseResponseEntity.getStatusCode().is2xxSuccessful() && body != null) {
            return customPdfResponse(body);
        }

        return pdfResponseResponseEntity;
    }

    //    CREW LIST
    @Override
    public ResponseEntity<?> createCrewList(CrewListTO payload) {
        String pdfName = "IMO_CrewList" + "_" + Instant.now().toEpochMilli() + ".pdf";
        String templateName = "IMO_CrewList";

        ResponseEntity<PdfResponseTO> pdfResponseResponseEntity = pdfGenerationService.generatePdf(pdfName, templateName, payload);

        PdfResponseTO body = pdfResponseResponseEntity.getBody();

        if (pdfResponseResponseEntity.getStatusCode().is2xxSuccessful() && body != null) {
            return customPdfResponse(body);
        }

        return pdfResponseResponseEntity;
    }

    //    PASSENGER LIST
    @Override
    public ResponseEntity<?> createPassengerList(PassengerListTO payload) {
        String pdfName = "IMO_PassengerList" + "_" + Instant.now().toEpochMilli() + ".pdf";
        String templateName = "IMO_PassengerList";

        ResponseEntity<PdfResponseTO> pdfResponseResponseEntity = pdfGenerationService.generatePdf(pdfName, templateName, payload);

        PdfResponseTO body = pdfResponseResponseEntity.getBody();

        if (pdfResponseResponseEntity.getStatusCode().is2xxSuccessful() && body != null) {
            return customPdfResponse(body);
        }

        return pdfResponseResponseEntity;
    }

    //    DANGEROUS GOODS MANIFEST
    @Override
    public ResponseEntity<?> createDangerousGoodsManifest(DangerousGoodsManifestTO payload) {
        String pdfName = "IMO_DangerousGoodsManifest" + "_" + Instant.now().toEpochMilli() + ".pdf";
        String templateName = "IMO_DangerousGoodsManifest";

        ResponseEntity<PdfResponseTO> pdfResponseResponseEntity = pdfGenerationService.generatePdf(pdfName, templateName, payload);

        PdfResponseTO body = pdfResponseResponseEntity.getBody();

        if (pdfResponseResponseEntity.getStatusCode().is2xxSuccessful() && body != null) {
            return customPdfResponse(body);
        }

        return pdfResponseResponseEntity;
    }

    //  SHIP PARTICULARS
    @Override
    public ResponseEntity<?> createShipsParticulars(ShipsDetailsTO payload) {
        String pdfName = "IMO_ShipsParticulars" + "_" + Instant.now().toEpochMilli() + ".pdf";
        String templateName = "IMO_ShipsParticulars";

        ResponseEntity<PdfResponseTO> pdfResponseResponseEntity = pdfGenerationService.generatePdf(pdfName, templateName, payload);

        PdfResponseTO body = pdfResponseResponseEntity.getBody();

        if (pdfResponseResponseEntity.getStatusCode().is2xxSuccessful() && body != null) {
            return customPdfResponse(body);
        }

        return pdfResponseResponseEntity;
    }

    //    GET DOCUMENTS
    @Override
    public ResponseEntity<byte[]> getDocument(String pdfName) {
        if (pdfName != null && pdfName.length() >= 3) {
            String last3 = pdfName.substring(pdfName.length() - 3);
            if (!last3.equals("pdf")) {
                throw new AppException(".pdf needs to be provided with pdf name.", HttpStatus.BAD_REQUEST);
            }
        }
        return pdfGenerationService.getPdf(pdfName);
    }

    private static ResponseEntity<?> customPdfResponse(PdfResponseTO body) {
        CustomPdfResponseTO pdfResponseTO = CustomPdfResponseTO.builder()
                .fileName(body.getData().getFileName())
                .message(body.getMessage())
                .status(body.getStatus())
                .getUrl("/imo/doc?pdfName=" + body.getData().getFileName())
                .build();

        return new ResponseEntity<>(pdfResponseTO, HttpStatus.OK);
    }

}

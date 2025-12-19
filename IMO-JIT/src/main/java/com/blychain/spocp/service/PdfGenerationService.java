package com.blychain.spocp.service;

import com.blychain.spocp.transferObject.PdfResponseTO;
import org.springframework.http.ResponseEntity;

public interface PdfGenerationService {
    ResponseEntity<PdfResponseTO> generatePdf(String pdfName, String templateName, Object payload);

    ResponseEntity<byte[]> getPdf(String pdfName);

}

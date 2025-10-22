package com.entoss.jita.service;


import com.entoss.jita.transferObject.VoyageTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;

public interface VoyageService {
    ResponseEntity<?> createVoyage(VoyageTO voyage);

    ResponseEntity<?> getVoyageById(String voyageNumber);

    ResponseEntity<?> updateVoyageById(String voyageNumber, VoyageTO voyageTO);

    ResponseEntity<?> deleteVoyageById(String voyageNumber);

    PagedModel<?> getAllVoyage(Pageable pageable);
}

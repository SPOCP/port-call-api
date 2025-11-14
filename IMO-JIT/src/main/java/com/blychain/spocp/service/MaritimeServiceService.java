package com.blychain.spocp.service;

import com.blychain.spocp.transferObject.MaritimeServiceTO;
import org.springframework.http.ResponseEntity;

public interface MaritimeServiceService {
    ResponseEntity<?> createMaritimeService(Long portCallId, MaritimeServiceTO maritimeServiceTO);

    ResponseEntity<?> getMaritimeServiceById(Long portCallId, Long maritimeServiceId);

    ResponseEntity<?> deleteMaritimeServiceById(Long portCallId, Long maritimeServiceId);

    ResponseEntity<?> updateMaritimeServiceById(Long portCallId, Long maritimeServiceId, MaritimeServiceTO maritimeServiceTO);
}

package com.blychain.spocp.service;

import com.blychain.spocp.transferObject.ItineraryTO;
import org.springframework.http.ResponseEntity;

public interface ItineraryService {

    ResponseEntity<?> createItinerary(String voyageNumber, ItineraryTO itineraryTO);

    ResponseEntity<?> getItineraryById(String voyageNumber, Long itineraryId);

    ResponseEntity<?> deleteItineraryById(String voyageNumber, Long itineraryId);

    ResponseEntity<?> updateItineraryById(String voyageNumber, Long itineraryId, ItineraryTO itineraryTO);

}

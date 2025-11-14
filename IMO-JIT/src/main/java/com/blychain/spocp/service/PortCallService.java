package com.blychain.spocp.service;

import com.blychain.spocp.transferObject.PortCallTO;
import org.springframework.http.ResponseEntity;

public interface PortCallService {

    ResponseEntity<?> createPortCall(String voyageNumber,PortCallTO portCallTO);

    ResponseEntity<?> getPortCallById(String voyageNumber, Long portCallId);

    ResponseEntity<?> updatePortCallById(String voyageNumber, Long portCallId, PortCallTO portCallTO);

    ResponseEntity<?> deletePortCallById(String voyageNumber, Long portCallId);

}

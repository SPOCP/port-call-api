package com.blychain.spocp.service;

import com.blychain.spocp.transferObject.MovementInPortTO;
import org.springframework.http.ResponseEntity;

public interface MovementInPortService {

    ResponseEntity<?> createMovementInPort(Long portCallId, MovementInPortTO movementInPortTO);

    ResponseEntity<?> getMovementInPortById(Long portCallId, Long movementInPortId);

    ResponseEntity<?> deleteMovementInPortyById(Long portCallId, Long movementInPortId);

    ResponseEntity<?> updateMovementInPortById(Long portCallId, Long movementInPortId, MovementInPortTO movementInPortTO);

}

package com.blychain.spocp.service.impl;

import com.blychain.spocp.entity.*;
import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.mapper.MovementInPortMapper;
import com.blychain.spocp.repository.MovementInPortRepository;
import com.blychain.spocp.repository.PortCallRepository;
import com.blychain.spocp.service.MovementInPortService;
import com.blychain.spocp.transferObject.MessageTO;
import com.blychain.spocp.transferObject.MovementInPortTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovementInPortServiceImpl implements MovementInPortService {

    //    Repository
    private final MovementInPortRepository movementInPortRepository;
    private final PortCallRepository portCallRepository;

    //    Mapper
    private final MovementInPortMapper movementInPortMapper;

    @Override
    public ResponseEntity<?> createMovementInPort(Long portCallId,
                                                  MovementInPortTO movementInPortTO) {

//        Finding If PortCall Exist or not
        PortCall portCall = portCallRepository.findByPortCallId(portCallId).orElseThrow(() ->
                new AppException("Cannot find PortCall with portCallId: " + portCallId, HttpStatus.NOT_FOUND)
        );

//        Converting Dto to Entity
        MovementInPort movementInPort = movementInPortMapper.dtoToMovementInPort(movementInPortTO);

//        Setting MovementInPortId
        long mpId = movementInPortRepository.findMaxId() + 1;
        movementInPort.setMovementInPortId(mpId);

//        Setting data for Bi-directional Mapping
        movementInPort.setPortCall(portCall);
        portCall.getMovementInPort().add(movementInPort);

//        Setting Data among internal Objects
        setDataForMovementInPort(movementInPort);

//        Saving Data
        MovementInPort save = movementInPortRepository.save(movementInPort);

        MovementInPortTO savedMovementInPort = movementInPortMapper.movementInPortToDto(save);
        return new ResponseEntity<>(savedMovementInPort, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> getMovementInPortById(Long portCallId, Long movementInPortId) {

//        Finding If PortCall Exist or not
        PortCall portCall = portCallRepository.findByPortCallId(portCallId).orElseThrow(() ->
                new AppException("Cannot find PortCall with portCallId: " + portCallId, HttpStatus.NOT_FOUND)
        );

//        Finding If MovementInPort Exist or not for particular PortCall
        MovementInPort movementInPort = movementInPortRepository.findByMovementInPortIdAndPortCall(movementInPortId, portCall).orElseThrow(() ->
                new AppException(String.format("Cannot find MovementInPort with movementInPortId: %d for portCallId: %s", movementInPortId, portCallId), HttpStatus.NOT_FOUND)
        );


        MovementInPortTO movementInPortTO = movementInPortMapper.movementInPortToDto(movementInPort);

        return new ResponseEntity<>(movementInPortTO, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateMovementInPortById(Long portCallId, Long movementInPortId, MovementInPortTO movementInPortTO) {

//        Finding If PortCall Exist or not
        PortCall portCall = portCallRepository.findByPortCallId(portCallId)
                .orElseThrow(() -> new AppException("Cannot find PortCall with portCallId: " + portCallId, HttpStatus.NOT_FOUND));

//        Finding If MovementInPort Exist or not for particular PortCall
        MovementInPort existing = movementInPortRepository.findByMovementInPortIdAndPortCall(movementInPortId, portCall)
                .orElseThrow(() -> new AppException(
                        String.format("Cannot find MovementInPort with movementInPortId: %d for portCallId: %s", movementInPortId, portCallId),
                        HttpStatus.NOT_FOUND));

//        Obtaining the MovementInPortId
        Long mpId = existing.getMovementInPortId();

//        Deleting the previous MovementInPort data with same MovementInPortId
        deleteMovementInPortyById(portCallId, mpId);
        portCallRepository.flush();

//        Converting Dto to Entity
        MovementInPort updateMovementInPort = movementInPortMapper.dtoToMovementInPort(movementInPortTO);

//        Setting MovementInPortId
        updateMovementInPort.setMovementInPortId(mpId);

//        Setting Data among internal Objects
        setDataForMovementInPort(updateMovementInPort);

//        Setting data for Bi-directional Mapping
        updateMovementInPort.setPortCall(portCall);
        portCall.getMovementInPort().add(updateMovementInPort);

//        Saving Data
        MovementInPort saved = movementInPortRepository.save(updateMovementInPort);

        MovementInPortTO savedDto = movementInPortMapper.movementInPortToDto(saved);
        return new ResponseEntity<>(savedDto, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteMovementInPortyById(Long portCallId, Long movementInPortId) {

//        Finding If PortCall Exist or not
        PortCall portCall = portCallRepository.findByPortCallId(portCallId)
                .orElseThrow(() -> new AppException("Cannot find PortCall with portCallId: " + portCallId, HttpStatus.NOT_FOUND));

//        Finding If MovementInPort Exist or not for particular PortCall
        MovementInPort movementInPort = movementInPortRepository.findByMovementInPortIdAndPortCall(movementInPortId, portCall)
                .orElseThrow(() -> new AppException(
                        String.format("Cannot find MovementInPort with movementInPortId: %d for portCallId: %s", movementInPortId, portCallId),
                        HttpStatus.NOT_FOUND));

//        Removing data from bi-directional mapping
        portCall.getMovementInPort().remove(movementInPort);
        movementInPort.setPortCall(null);

//        Saving Data
        portCallRepository.save(portCall);

        MessageTO message = new MessageTO(
                String.format("Successfully Deleted MovementInPort of movementInPortId: %d from PortCall", movementInPortId));

        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }




    private void setDataForMovementInPort(MovementInPort movementInPort) {
        if (movementInPort.getMovementInPortLocation() != null) {
            MovementInPortLocation mpLocation = movementInPort.getMovementInPortLocation();
            mpLocation.setMovementInPort(movementInPort);

            if (mpLocation.getGeographicalPosition() != null) {
                GeographicalPosition geographicalPosition = mpLocation.getGeographicalPosition();
                geographicalPosition.setMovementInPortLocation(mpLocation);
            }
        }
    }


}

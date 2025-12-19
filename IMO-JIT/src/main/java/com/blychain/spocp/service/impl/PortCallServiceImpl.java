package com.blychain.spocp.service.impl;

import com.blychain.spocp.entity.PortCall;
import com.blychain.spocp.entity.Voyage;
import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.mapper.PortCallMapper;
import com.blychain.spocp.repository.PortCallRepository;
import com.blychain.spocp.repository.VoyageRepository;
import com.blychain.spocp.service.PortCallService;
import com.blychain.spocp.transferObject.MessageTO;
import com.blychain.spocp.transferObject.PortCallTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PortCallServiceImpl implements PortCallService {

    //    Repository
    private final PortCallRepository portCallRepository;
    private final VoyageRepository voyageRepository;

    //    Mapper
    private final PortCallMapper portCallMapper;

    //    Service
    private final ValidationServiceImpl validationService;
    private final SetDataServiceImpl setDataService;

    @Override
    public ResponseEntity<?> createPortCall(String voyageNumber, PortCallTO portCallTO) {

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Validating the Data (Please add required username and password)
        validationService.validatePortCall(portCallTO);

//        Converting Dto to Entity
        PortCall portCall = portCallMapper.dtoToPortCall(portCallTO);

//        Setting data and Bi-directional Mapping
        Long pcId = portCallRepository.findMaxId() + 1;
        setDataService.setDataForPortCall(portCall, voyage, pcId);
        voyage.getPortCall().add(portCall);

//        Saving Data
        PortCall save = portCallRepository.save(portCall);

        PortCallTO savedPortCall = portCallMapper.portCallToDto(save);

        return new ResponseEntity<>(savedPortCall, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getPortCallById(String voyageNumber, Long portCallId) {

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Finding If PortCall Exist or not for particular Voyage
        PortCall portCall = portCallRepository.findByPortCallIdAndVoyage(portCallId, voyage)
                .orElseThrow(() ->
                        new AppException(String.format("Cannot find PortCall with portCallId: %d for voyageNumber: %s", portCallId, voyageNumber), HttpStatus.NOT_FOUND)
                );

//        Converting Entity to DTO
        PortCallTO portCallTO = portCallMapper.portCallToDto(portCall);

        return new ResponseEntity<>(portCallTO, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updatePortCallById(String voyageNumber, Long portCallId, PortCallTO portCallTO) {

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Finding If PortCall Exist or not for particular Voyage
        PortCall existingPortCall = portCallRepository.findByPortCallIdAndVoyage(portCallId, voyage)
                .orElseThrow(() ->
                        new AppException(String.format("Cannot find PortCall with portCallId: %d for voyageNumber: %s", portCallId, voyageNumber), HttpStatus.NOT_FOUND)
                );

//        Validating the Data
        validationService.validatePortCall(portCallTO);

//        Deleting the previous PortCall data with same PortCallId
        deletePortCallById(voyageNumber, portCallId);
        voyageRepository.flush();

//        Converting Dto to Entity
        PortCall updatedPortCall = portCallMapper.dtoToPortCall(portCallTO);

//        Setting data and Bi-directional Mapping
        setDataService.setDataForPortCall(updatedPortCall, voyage, portCallId);
        voyage.getPortCall().add(updatedPortCall);


//        Saving Data
        PortCall save = portCallRepository.save(updatedPortCall);

        PortCallTO savedPortCall = portCallMapper.portCallToDto(save);

        return new ResponseEntity<>(savedPortCall, HttpStatus.ACCEPTED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deletePortCallById(String voyageNumber, Long portCallId) {

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Finding If PortCall Exist or not for particular Voyage
        PortCall portCall = portCallRepository.findByPortCallIdAndVoyage(portCallId, voyage).orElseThrow(() ->
                new AppException(String.format("Cannot find PortCall with portCallId: %d for voyageNumber: %s", portCallId, voyageNumber), HttpStatus.NOT_FOUND)
        );

//        Removing data from bi-directional mapping
        voyage.getPortCall().remove(portCall);
        portCall.setVoyage(null);

//        Saving Data
        voyageRepository.save(voyage);

        MessageTO message = new MessageTO(String.format("Successfully Deleted PortCall of portCallId: %d from Voyage", portCallId));

        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

}

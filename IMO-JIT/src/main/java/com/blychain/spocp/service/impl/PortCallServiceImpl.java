package com.blychain.spocp.service.impl;

import com.blychain.spocp.entity.*;
import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.mapper.PortCallMapper;
import com.blychain.spocp.repository.MaritimeServiceRepository;
import com.blychain.spocp.repository.MovementInPortRepository;
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

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortCallServiceImpl implements PortCallService {

    //    Repository
    private final PortCallRepository portCallRepository;
    private final VoyageRepository voyageRepository;
    private final MovementInPortRepository movementInPortRepository;
    private final MaritimeServiceRepository maritimeServiceRepository;

    //    Mapper
    private final PortCallMapper portCallMapper;

    //    Service
    private final ValidationServiceImpl validationService;

    @Override
    public ResponseEntity<?> createPortCall(String voyageNumber, PortCallTO portCallTO) {

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Validating the Data
        validationService.validatePortCall(portCallTO);

//        Converting Dto to Entity
        PortCall portCall = portCallMapper.dtoToPortCall(portCallTO);

//        Setting data for Bi-directional Mapping
        portCall.setVoyage(voyage);

//        Setting Data among internal Objects
        setDataForPortCall(portCall);

//        Setting PortCallId
        Long pcId = portCallRepository.findMaxId() + 1;
        portCall.setPortCallId(pcId);

//        Adding to Voyage Entity
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

//        Obtaining the PortCallId
        Long pcId = existingPortCall.getPortCallId();

//        Deleting the previous PortCall data with same PortCallId
        deletePortCallById(voyageNumber, pcId);
        voyageRepository.flush();

//        Converting Dto to Entity
        PortCall updatedPortCall = portCallMapper.dtoToPortCall(portCallTO);

//        Setting Data among internal Objects
        setDataForPortCall(updatedPortCall);

//        Setting data for Bi-directional Mapping
        updatedPortCall.setVoyage(voyage);
        voyage.getPortCall().add(updatedPortCall);

//        Setting PortCallId
        updatedPortCall.setPortCallId(pcId);

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


    private void setDataForPortCall(PortCall pc) {

//                Agent At Port
        if (pc.getAgentAtPort() != null) {
            AgentAtPort agentAtPort = pc.getAgentAtPort();
            agentAtPort.setPortCall(pc);

            if (agentAtPort.getAgentAtPortAddress() != null) {
                agentAtPort.getAgentAtPortAddress().setAgentAtPort(agentAtPort);
            }

            if (agentAtPort.getAgentAtPortCommunication() != null) {
                agentAtPort.getAgentAtPortCommunication().setAgentAtPort(agentAtPort);
            }
        }

//                Primary Purpose of Call
        if (pc.getPrimaryPurposesOfCall() != null) {
            pc.getPrimaryPurposesOfCall().setPortCall(pc);
        }

//                Movement In Port
        List<MovementInPort> movementInPort = pc.getMovementInPort();
        if (movementInPort != null) {
            long mpId = movementInPortRepository.findMaxId() + 1;
            for (MovementInPort mp : movementInPort) {
                mp.setPortCall(pc);
                mp.setMovementInPortId(mpId);
                mpId++;

                if (mp.getMovementInPortLocation() != null) {
                    MovementInPortLocation mpLocation = mp.getMovementInPortLocation();
                    mpLocation.setMovementInPort(mp);

                    if (mpLocation.getGeographicalPosition() != null) {
                        mpLocation.getGeographicalPosition().setMovementInPortLocation(mpLocation);
                    }
                }
            }
        }

//                Maritime Service
        List<MaritimeService> maritimeService = pc.getMaritimeService();
        if (maritimeService != null) {
            Long msId = maritimeServiceRepository.findMaxId() + 1;
            for (MaritimeService ms : maritimeService) {
                ms.setPortCall(pc);
                ms.setMaritimeServiceId(msId);
                msId++;

                if (ms.getContactDetails() != null) {

                    ContactDetails cd = ms.getContactDetails();

                    cd.setMaritimeService(ms);

                    if (cd.getCommunication() != null) {
                        cd.getCommunication().setContactDetails(cd);
                    }
                }

                if (ms.getMaritimeServiceStartEvent() != null) {
                    ms.getMaritimeServiceStartEvent().setMaritimeService(ms);
                }

                if (ms.getMaritimeServiceCompletionEvent() != null) {
                    ms.getMaritimeServiceCompletionEvent().setMaritimeService(ms);
                }
            }
        }

    }

}

package com.blychain.spocp.service.impl;

import com.blychain.spocp.entity.ContactDetails;
import com.blychain.spocp.entity.MaritimeService;
import com.blychain.spocp.entity.PortCall;
import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.mapper.MaritimeServiceMapper;
import com.blychain.spocp.repository.MaritimeServiceRepository;
import com.blychain.spocp.repository.PortCallRepository;
import com.blychain.spocp.service.MaritimeServiceService;
import com.blychain.spocp.transferObject.MaritimeServiceTO;
import com.blychain.spocp.transferObject.MessageTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MaritimeServiceServiceImpl implements MaritimeServiceService {

    //    Repository
    private final PortCallRepository portCallRepository;
    private final MaritimeServiceRepository maritimeServiceRepository;

    //    Mapper
    private final MaritimeServiceMapper maritimeServiceMapper;

    //    Service
    private final ValidationServiceImpl validationService;

    @Override
    public ResponseEntity<?> createMaritimeService(Long portCallId, MaritimeServiceTO maritimeServiceTO) {

//        Finding If PortCall Exist or not
        PortCall portCall = portCallRepository.findByPortCallId(portCallId).orElseThrow(() ->
                new AppException("Cannot find PortCall with portCallId: " + portCallId, HttpStatus.NOT_FOUND)
        );

//        Validating the Data
        validationService.validateMaritimeService(maritimeServiceTO);

//        Convert Dto to Entity
        MaritimeService maritimeService = maritimeServiceMapper.dtoToMaritimeService(maritimeServiceTO);

//        Setting MaritimeServiceId
        long msId = maritimeServiceRepository.findMaxId() + 1;
        maritimeService.setMaritimeServiceId(msId);

//        Setting data for Bi-directional Mapping
        maritimeService.setPortCall(portCall);
        portCall.getMaritimeService().add(maritimeService);

//        Setting Data among internal Objects
        setDataForMaritimeService(maritimeService);

//        Saving Data
        MaritimeService save = maritimeServiceRepository.save(maritimeService);

        MaritimeServiceTO savedMaritimeService = maritimeServiceMapper.maritimeServiceToDto(save);
        return new ResponseEntity<>(savedMaritimeService, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> getMaritimeServiceById(Long portCallId, Long maritimeServiceId) {

//        Finding If PortCall Exist or not
        PortCall portCall = portCallRepository.findByPortCallId(portCallId).orElseThrow(() ->
                new AppException("Cannot find PortCall with portCallId: " + portCallId, HttpStatus.NOT_FOUND)
        );

//        Finding If MaritimeService Exist or not for particular PortCall
        MaritimeService maritimeService = maritimeServiceRepository.findByMaritimeServiceIdAndPortCall(maritimeServiceId, portCall).orElseThrow(() ->
                new AppException(String.format("Cannot find MaritimeService with maritimeServiceId: %d for portCallId: %s", maritimeServiceId, portCallId), HttpStatus.NOT_FOUND)
        );

        MaritimeServiceTO maritimeServiceTO = maritimeServiceMapper.maritimeServiceToDto(maritimeService);
        return new ResponseEntity<>(maritimeServiceTO, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateMaritimeServiceById(Long portCallId, Long maritimeServiceId, MaritimeServiceTO maritimeServiceTO) {

//        Finding If PortCall Exist or not
        PortCall portCall = portCallRepository.findByPortCallId(portCallId).orElseThrow(() ->
                new AppException("Cannot find PortCall with portCallId: " + portCallId, HttpStatus.NOT_FOUND)
        );

//        Finding If MaritimeService Exist or not for particular PortCall
        MaritimeService existing = maritimeServiceRepository.findByMaritimeServiceIdAndPortCall(maritimeServiceId, portCall).orElseThrow(() ->
                new AppException(String.format("Cannot find MaritimeService with maritimeServiceId: %d for portCallId: %s", maritimeServiceId, portCallId), HttpStatus.NOT_FOUND)
        );

//        Validating the Data
        validationService.validateMaritimeService(maritimeServiceTO);

//        Obtaining the MaritimeServiceId
        Long msId = existing.getMaritimeServiceId();

//        Deleting the previous MaritimeService data with same MaritimeServiceId
        deleteMaritimeServiceById(portCallId, msId);
        portCallRepository.flush();

//      Converting Dto to Entity
        MaritimeService updateMaritimeService = maritimeServiceMapper.dtoToMaritimeService(maritimeServiceTO);

//        Setting MaritimeServiceId
        updateMaritimeService.setMaritimeServiceId(msId);

//        Setting data for Bi-directional Mapping
        updateMaritimeService.setPortCall(portCall);
        portCall.getMaritimeService().add(updateMaritimeService);

//        Setting Data among internal Objects
        setDataForMaritimeService(updateMaritimeService);

//        Saving Data
        MaritimeService save = maritimeServiceRepository.save(updateMaritimeService);

        MaritimeServiceTO savedMaritimeService = maritimeServiceMapper.maritimeServiceToDto(save);
        return new ResponseEntity<>(savedMaritimeService, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteMaritimeServiceById(Long portCallId, Long maritimeServiceId) {

//        Finding If PortCall Exist or not
        PortCall portCall = portCallRepository.findByPortCallId(portCallId).orElseThrow(() ->
                new AppException("Cannot find PortCall with portCallId: " + portCallId, HttpStatus.NOT_FOUND)
        );

//        Finding If MaritimeService Exist or not for particular PortCall
        MaritimeService maritimeService = maritimeServiceRepository.findByMaritimeServiceIdAndPortCall(maritimeServiceId, portCall).orElseThrow(() ->
                new AppException(String.format("Cannot find MaritimeService with maritimeServiceId: %d for portCallId: %s", maritimeServiceId, portCallId), HttpStatus.NOT_FOUND)
        );

//        Removing data from bi-directional mapping
        portCall.getMaritimeService().remove(maritimeService);
        maritimeService.setPortCall(null);

//        Saving Data
        portCallRepository.save(portCall);

        MessageTO message = new MessageTO(String.format("Successfully Deleted MaritimeService of maritimeServiceId: %d from PortCall", maritimeServiceId));
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }


    private void setDataForMaritimeService(MaritimeService ms) {

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

package com.blychain.spocp.service.impl;

import com.blychain.spocp.entity.*;
import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.mapper.VoyageMapper;
import com.blychain.spocp.repository.*;
import com.blychain.spocp.service.VoyageService;
import com.blychain.spocp.transferObject.MessageTO;
import com.blychain.spocp.transferObject.VoyageTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoyageServiceImpl implements VoyageService {

    //    Repository
    private final VoyageRepository voyageRepository;
    private final PortCallRepository portCallRepository;
    private final ItineraryRepository itineraryRepository;
    private final MovementInPortRepository movementInPortRepository;
    private final MaritimeServiceRepository maritimeServiceRepository;

    //    Service
    private final ValidationServiceImpl validationService;

    //    Mapper
    private final VoyageMapper voyageMapper;

    @Override
    public ResponseEntity<?> createVoyage(VoyageTO voyageTO) {

//        Validating the Data
        validationService.validateInformation(voyageTO);

//        Converting Dto to Entity
        Voyage voyage = voyageMapper.dtoToVoyage(voyageTO);

//        Setting Data among internal Objects
        setDataForVoyage(voyage);

//        Saving Data
        Voyage save = voyageRepository.save(voyage);

        VoyageTO savedVoyage = voyageMapper.voyageToDto(save);

        return new ResponseEntity<>(savedVoyage, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getVoyageById(String voyageNumber) {

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber)
                .orElseThrow(() ->
                        new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
                );

        VoyageTO voyageTO = voyageMapper.voyageToDto(voyage);

        return new ResponseEntity<>(voyageTO, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateVoyageById(String voyageNumber, VoyageTO voyageTO) {

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber)
                .orElseThrow(() ->
                        new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
                );

        if (voyageNumber != voyage.getVoyageNumber()) {
            throw new AppException("Different VoyageNumber is passed in the payload, VoyageNumber: " + voyageNumber, HttpStatus.BAD_REQUEST);
        }

//        Validating the Data
        validationService.validateInformation(voyageTO);

//        Deleting the existing Voyage by voyageNumber
        voyageRepository.deleteByVoyageNumber(voyageNumber);
        voyageRepository.flush();

//        Converting Dto to Entity
        Voyage updatedVoyage = voyageMapper.dtoToVoyage(voyageTO);

//        Setting VoyageNumber
        updatedVoyage.setVoyageNumber(voyageNumber);

//        Setting Data among internal Objects
        setDataForVoyage(updatedVoyage);

//        Saving Data
        Voyage save = voyageRepository.save(updatedVoyage);

        VoyageTO savedVoyage = voyageMapper.voyageToDto(save);

        return new ResponseEntity<>(savedVoyage, HttpStatus.ACCEPTED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteVoyageById(String voyageNumber) {

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber)
                .orElseThrow(() ->
                        new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
                );

//        Deleting Voyage by voyageNumber
        voyageRepository.deleteByVoyageNumber(voyageNumber);

        MessageTO message = new MessageTO("Successfully Deleted Voyage with voyageNumber: " + voyageNumber);

        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }


    @Override
    public PagedModel<?> getAllVoyage(Pageable pageable) {
        Page<Voyage> allVoyages = voyageRepository.findAll(pageable);
        Page<VoyageTO> voyages = allVoyages.map(voyageMapper::voyageToDto);

        return new PagedModel<>(voyages);
    }


    /**
     * Sets up bidirectional relationships and assigns sequential IDs
     * for nested entities within the Voyage aggregate structure.
     * <p>
     * This method ensures that all child entities (Ship, Itinerary, PortCall, etc.)
     * are properly linked to their parent entities before persistence.
     */
    private void setDataForVoyage(Voyage voyage) {

//        --- Ship ---
//        If Ship exists, link it back to Voyage
        if (voyage.getShip() != null) {
            voyage.getShip().setVoyage(voyage);
        }

//        --- Itinerary ---
//        Assign sequential itinerary IDs and set Voyage reference
        List<Itinerary> itinerary = voyage.getItinerary();
        if (itinerary != null) {
            Long maxId = itineraryRepository.findMaxId() + 1;
            for (Itinerary it : itinerary) {
                it.setVoyage(voyage);
                it.setItineraryId(maxId);
                maxId++;
            }
        }

//        --- PortCall ---
//        Assign sequential portCall IDs and set Voyage reference
        List<PortCall> portCall = voyage.getPortCall();
        if (portCall != null) {
            Long maxId = portCallRepository.findMaxId() + 1;

            for (PortCall pc : portCall) {
                pc.setVoyage(voyage);
                pc.setPortCallId(maxId);
                maxId++;

                // -------------------- AgentAtPort --------------------
                if (pc.getAgentAtPort() != null) {
                    AgentAtPort agentAtPort = pc.getAgentAtPort();
                    agentAtPort.setPortCall(pc);

                    // Agent Address (One-to-One)
                    if (agentAtPort.getAgentAtPortAddress() != null) {
                        agentAtPort.getAgentAtPortAddress().setAgentAtPort(agentAtPort);
                    }

                    // Agent Communication (One-to-One)
                    if (agentAtPort.getAgentAtPortCommunication() != null) {
                        agentAtPort.getAgentAtPortCommunication().setAgentAtPort(agentAtPort);
                    }
                }

                // -------------------- Primary Purpose of Call --------------------
                if (pc.getPrimaryPurposesOfCall() != null) {
                    pc.getPrimaryPurposesOfCall().setPortCall(pc);
                }

                // -------------------- Movement In Port --------------------
                List<MovementInPort> movementInPort = pc.getMovementInPort();
                if (movementInPort != null) {
                    long mpId = movementInPortRepository.findMaxId() + 1;

                    for (MovementInPort mp : movementInPort) {
                        mp.setPortCall(pc);
                        mp.setMovementInPortId(mpId);
                        mpId++;

                        // --- Movement In Port Location ---
                        if (mp.getMovementInPortLocation() != null) {
                            MovementInPortLocation mpLocation = mp.getMovementInPortLocation();
                            mpLocation.setMovementInPort(mp);

                            // Geographical Position under MovementInPortLocation
                            if (mpLocation.getGeographicalPosition() != null) {
                                mpLocation.getGeographicalPosition().setMovementInPortLocation(mpLocation);
                            }
                        }
                    }
                }

                // -------------------- Maritime Service --------------------
                List<MaritimeService> maritimeService = pc.getMaritimeService();
                if (maritimeService != null) {
                    Long msId = maritimeServiceRepository.findMaxId() + 1;

                    for (MaritimeService ms : maritimeService) {
                        ms.setPortCall(pc);
                        ms.setMaritimeServiceId(msId);
                        msId++;

                        // --- Contact Details ---
                        if (ms.getContactDetails() != null) {
                            ContactDetails cd = ms.getContactDetails();
                            cd.setMaritimeService(ms);

                            // Contact Communication (One-to-One)
                            if (cd.getCommunication() != null) {
                                cd.getCommunication().setContactDetails(cd);
                            }
                        }

                        // --- Maritime Service Start Event ---
                        if (ms.getMaritimeServiceStartEvent() != null) {
                            ms.getMaritimeServiceStartEvent().setMaritimeService(ms);
                        }

                        // --- Maritime Service Completion Event ---
                        if (ms.getMaritimeServiceCompletionEvent() != null) {
                            ms.getMaritimeServiceCompletionEvent().setMaritimeService(ms);
                        }
                    }
                }
            }
        }
    }


}

package com.blychain.spocp.service.impl;

import com.blychain.spocp.entity.*;
import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.repository.ItineraryRepository;
import com.blychain.spocp.repository.MaritimeServiceRepository;
import com.blychain.spocp.repository.MovementInPortRepository;
import com.blychain.spocp.repository.PortCallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SetDataServiceImpl {

    private final PortCallRepository portCallRepository;
    private final ItineraryRepository itineraryRepository;
    private final MovementInPortRepository movementInPortRepository;
    private final MaritimeServiceRepository maritimeServiceRepository;

    /**
     * Sets up bidirectional relationships and assigns sequential IDs
     * for nested entities within the Voyage aggregate structure.
     * <p>
     * This method ensures that all child entities (Ship, Itinerary, PortCall, etc.)
     * are properly linked to their parent entities before persistence.
     */
    public void setDataForVoyage(Voyage voyage) {

//        --- Ship ---
//        If Ship exists, link it back to Voyage
        if (voyage.getShip() != null) {
            voyage.getShip().setVoyage(voyage);
        }

//        --- Itinerary ---
//        Assign sequential itinerary IDs and set Voyage reference
        List<Itinerary> itinerary = voyage.getItinerary();
        if (itinerary != null) {
            Long itId = itineraryRepository.findMaxId() + 1;
            for (Itinerary it : itinerary) {
                setDataForItinerary(it, voyage, itId);
                itId++;
            }
        }

//        --- PortCall ---
//        Assign sequential portCall IDs and set Voyage reference
        List<PortCall> portCall = voyage.getPortCall();
        if (portCall != null) {
            Long pcId = portCallRepository.findMaxId() + 1;

            for (PortCall pc : portCall) {
                setDataForPortCall(pc, voyage, pcId);
                pcId++;
            }
        }
    }


    public void setDataForPortCall(PortCall pc, Voyage voyage, Long pcId) {

        if(Objects.equals(pc.getPortOfArrivalName(), pc.getPortOfDepartureName())){
            throw new AppException(
                    "PortOfArrivalName and PortOfDepartureName cannot be same",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (!isOrdered(pc.getDateAndTimeOfDepartureRequested(),
                pc.getDateAndTimeOfDeparturePlanned(),
                pc.getDateAndTimeOfDepartureEstimated(),
                pc.getDateAndTimeOfDepartureActual())) {
            throw new AppException(
                    "DateAndTimeOfDeparture must follow the order: Requested ≤ Planned ≤ Estimated ≤ Actual",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (!isOrdered(pc.getDateAndTimeOfArrivalRequested(),
                pc.getDateAndTimeOfArrivalPlanned(),
                pc.getDateAndTimeOfArrivalEstimated(),
                pc.getDateAndTimeOfArrivalActual())) {
            throw new AppException(
                    "DateAndTimeOfArrival must follow the order: Requested ≤ Planned ≤ Estimated ≤ Actual",
                    HttpStatus.BAD_REQUEST
            );
        }

        if(!pc.getDateAndTimeOfDepartureActual().isBefore(pc.getDateAndTimeOfArrivalRequested())){
            throw new AppException(
                    "DateAndTimeOfArrival Requested must be greater than DateAndTimeOfDeparture Actual",
                    HttpStatus.BAD_REQUEST
            );
        }

        pc.setVoyage(voyage);
        pc.setPortCallId(pcId);

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
                setDataForMovementInPort(mp, pc, mpId);
                mpId++;
            }
        }

//                Maritime Service
        List<MaritimeService> maritimeService = pc.getMaritimeService();
        if (maritimeService != null) {
            Long msId = maritimeServiceRepository.findMaxId() + 1;
            for (MaritimeService ms : maritimeService) {
                setDataForMaritimeService(ms, pc, msId);
                msId++;

            }
        }

    }

    public void setDataForMovementInPort(MovementInPort mp, PortCall pc, Long mpId) {

        mp.setPortCall(pc);
        mp.setMovementInPortId(mpId);

        if (mp.getMovementInPortLocation() != null) {
            MovementInPortLocation mpLocation = mp.getMovementInPortLocation();
            mpLocation.setMovementInPort(mp);

            if (mpLocation.getGeographicalPosition() != null) {
                GeographicalPosition geographicalPosition = mpLocation.getGeographicalPosition();
                geographicalPosition.setMovementInPortLocation(mpLocation);
            }
        }
    }

    public void setDataForMaritimeService(MaritimeService ms, PortCall pc, Long msId) {

        if (ms.getMaritimeServiceStartEvent() != null) {

            MaritimeServiceStartEvent msStartEvent = ms.getMaritimeServiceStartEvent();

            OffsetDateTime requested = msStartEvent.getDateAndTimeOfServiceStartRequested();
            OffsetDateTime planned = msStartEvent.getDateAndTimeOfServiceStartPlanned();
            OffsetDateTime estimated = msStartEvent.getDateAndTimeOfServiceStartEstimated();
            OffsetDateTime actual = msStartEvent.getDateAndTimeOfServiceStartActual();

            if (!isOrdered(requested, planned, estimated, actual)) {
                throw new AppException(
                        "MaritimeServiceStartEvent must follow the order: Requested ≤ Planned ≤ Estimated ≤ Actual",
                        HttpStatus.BAD_REQUEST
                );
            }

            if (ms.getMaritimeServiceCompletionEvent() != null) {

                MaritimeServiceCompletionEvent msCompletionEvent =
                        ms.getMaritimeServiceCompletionEvent();

                OffsetDateTime requested1 =
                        msCompletionEvent.getDateAndTimeOfServiceCompletionRequested();
                OffsetDateTime planned1 =
                        msCompletionEvent.getDateAndTimeOfServiceCompletionPlanned();
                OffsetDateTime estimated1 =
                        msCompletionEvent.getDateAndTimeOfServiceCompletionEstimated();
                OffsetDateTime actual1 =
                        msCompletionEvent.getDateAndTimeOfServiceCompletionActual();

                if (!isOrdered(requested1, planned1, estimated1, actual1)) {
                    throw new AppException(
                            "MaritimeServiceCompletionEvent must follow the order: Requested ≤ Planned ≤ Estimated ≤ Actual",
                            HttpStatus.BAD_REQUEST
                    );
                }

                // Completion Requested must be >= Start Actual
                if (requested1.isBefore(actual)) {
                    throw new AppException(
                            "MaritimeServiceCompletionEvent Requested must be greater than  MaritimeServiceStartEvent Actual",
                            HttpStatus.BAD_REQUEST
                    );
                }
            }
        }

        ms.setPortCall(pc);
        ms.setMaritimeServiceId(msId);

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

    private boolean isOrdered(OffsetDateTime requested, OffsetDateTime planned,
                              OffsetDateTime estimated, OffsetDateTime actual) {
        return !requested.isAfter(planned)
                && !planned.isAfter(estimated)
                && !estimated.isAfter(actual);
    }

    public void setDataForItinerary(Itinerary it, Voyage voyage, Long itId) {
        it.setVoyage(voyage);
        it.setItineraryId(itId);
    }

}

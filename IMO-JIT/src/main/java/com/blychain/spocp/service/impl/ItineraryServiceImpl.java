package com.blychain.spocp.service.impl;

import com.blychain.spocp.entity.Itinerary;
import com.blychain.spocp.entity.Voyage;
import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.mapper.ItineraryMapper;
import com.blychain.spocp.repository.ItineraryRepository;
import com.blychain.spocp.repository.VoyageRepository;
import com.blychain.spocp.service.ItineraryService;
import com.blychain.spocp.transferObject.ItineraryTO;
import com.blychain.spocp.transferObject.MessageTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItineraryServiceImpl implements ItineraryService {

    //    Repository
    private final ItineraryRepository itineraryRepository;
    private final VoyageRepository voyageRepository;

    //    Mapper
    private final ItineraryMapper itineraryMapper;

    @Override
    public ResponseEntity<?> createItinerary(String voyageNumber, ItineraryTO itineraryTO) {

//        Finding If voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Converting DTO to Entity
        Itinerary itinerary = itineraryMapper.dtoToItinerary(itineraryTO);

//        Setting ItineraryId
        Long itId = itineraryRepository.findMaxId() + 1;
        itinerary.setItineraryId(itId);

//        Setting data for Bi-directional Mapping
        voyage.getItinerary().add(itinerary);
        itinerary.setVoyage(voyage);

//        Saving Data
        Itinerary save = itineraryRepository.save(itinerary);

        ItineraryTO savedItinerary = itineraryMapper.itineraryToDto(save);
        return new ResponseEntity<>(savedItinerary, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> getItineraryById(String voyageNumber, Long itineraryId) {

//        Finding If voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Finding If Itinerary Exist for particular Voyage
        Itinerary itinerary = itineraryRepository.findByItineraryIdAndVoyage(itineraryId, voyage)
                .orElseThrow(() ->
                        new AppException(String.format("Cannot find Itinerary with itineraryId: %d for voyageNumber: %s", itineraryId, voyageNumber), HttpStatus.NOT_FOUND)
                );

        ItineraryTO itineraryTO = itineraryMapper.itineraryToDto(itinerary);
        return new ResponseEntity<>(itineraryTO, HttpStatus.OK);
    }


    @Override
    @Transactional
    public ResponseEntity<?> updateItineraryById(String voyageNumber, Long itineraryId, ItineraryTO itineraryTO) {

//        Finding If voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Finding If Itinerary Exist for particular Voyage
        Itinerary itinerary = itineraryRepository.findByItineraryIdAndVoyage(itineraryId, voyage).orElseThrow(() ->
                new AppException(String.format("Cannot find Itinerary with itineraryId: %d for voyageNumber: %s", itineraryId, voyageNumber), HttpStatus.NOT_FOUND)
        );

//        Obtaining the itinerary Id
        Long itId = itinerary.getItineraryId();

//        Deleting the previous itinerary with same itinerary Id
        deleteItineraryById(voyageNumber, itId);
        voyageRepository.flush();

//        Converting Dto to Entity
        Itinerary upItinerary = itineraryMapper.dtoToItinerary(itineraryTO);

//        Setting data for bi-directional mapping
        upItinerary.setItineraryId(itId);
        upItinerary.setVoyage(voyage);
        voyage.getItinerary().add(upItinerary);

//        Saving Data
        Itinerary save = itineraryRepository.save(upItinerary);

        ItineraryTO savedItinerary = itineraryMapper.itineraryToDto(save);
        return new ResponseEntity<>(savedItinerary, HttpStatus.ACCEPTED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteItineraryById(String voyageNumber, Long itineraryId) {

//        Finding If voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber).orElseThrow(() ->
                new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
        );

//        Finding If Itinerary Exist for particular Voyage
        Itinerary itinerary = itineraryRepository.findByItineraryIdAndVoyage(itineraryId, voyage)
                .orElseThrow(() ->
                        new AppException(String.format("Cannot find Itinerary with itineraryId: %d for voyageNumber: %s", itineraryId, voyageNumber), HttpStatus.NOT_FOUND)
                );

//        Removing data from bi-directional mapping
        voyage.getItinerary().remove(itinerary);
        itinerary.setVoyage(null);

//        Saving Data
        voyageRepository.save(voyage);

        MessageTO message = new MessageTO(String.format("Successfully Deleted itinerary of itineraryId: %d from Voyage", itineraryId));
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }


}

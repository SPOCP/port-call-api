package com.blychain.spocp.service.impl;

import com.blychain.spocp.entity.Voyage;
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

import java.util.Objects;

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
    private final SetDataServiceImpl setDataService;

    //    Mapper
    private final VoyageMapper voyageMapper;

    @Override
    public ResponseEntity<?> createVoyage(VoyageTO voyageTO) {

//        Validating the Data (Please add required username and password)
        validationService.validateInformation(voyageTO);

//        Converting Dto to Entity
        Voyage voyage = voyageMapper.dtoToVoyage(voyageTO);

//        Setting Data
        setDataService.setDataForVoyage(voyage);

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

        if (!Objects.equals(voyageNumber, voyageTO.getVoyageNumber())) {
            throw new AppException("Different VoyageNumber is passed in the payload, VoyageNumber: " + voyageNumber, HttpStatus.BAD_REQUEST);
        }

//        Finding If Voyage Exist or not
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber)
                .orElseThrow(() ->
                        new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
                );

//        Validating the Data
        validationService.validateInformation(voyageTO);

//        Deleting the existing Voyage by voyageNumber
        voyageRepository.deleteByVoyageNumber(voyageNumber);
        voyageRepository.flush();

//        Converting Dto to Entity
        Voyage updatedVoyage = voyageMapper.dtoToVoyage(voyageTO);

//        Setting VoyageNumber
        updatedVoyage.setVoyageNumber(voyageNumber);

//        Setting Data
        setDataService.setDataForVoyage(updatedVoyage);

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


}

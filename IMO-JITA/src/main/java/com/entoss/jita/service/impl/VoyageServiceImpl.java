package com.entoss.jita.service.impl;

import com.entoss.jita.entity.Voyage;
import com.entoss.jita.mapper.VoyageMapper;
import com.entoss.jita.service.VoyageService;
import com.entoss.jita.transferObject.MessageTO;
import com.entoss.jita.exception.AppException;
import com.entoss.jita.repository.VoyageRepository;
import com.entoss.jita.transferObject.VoyageTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VoyageServiceImpl implements VoyageService {

    //Repository
    private final VoyageRepository voyageRepository;

    //Service
    private final ValidationServiceImpl validationService;

    //Mapper
    private final VoyageMapper voyageMapper;

    @Override
    @Transactional
    public ResponseEntity<?> createVoyage(VoyageTO voyageTO) {
        validationService.validateInformation(voyageTO);
        Voyage voyage = voyageMapper.dtoToVoyage(voyageTO);
        Voyage save = voyageRepository.save(voyage);
        MessageTO voyageResponseTO = new MessageTO("Voyage Successfully created for voyageNumber: " + save.getVoyageNumber());
        return new ResponseEntity<>(voyageResponseTO, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<?> getVoyageById(String voyageNumber) {
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
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber)
                .orElseThrow(() ->
                        new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
                );

        voyageRepository.deleteByVoyageNumber(voyageNumber);
        voyageRepository.flush();

        Voyage voyage1 = voyageMapper.dtoToVoyage(voyageTO);
        voyage1.setVoyageNumber(voyageNumber);
        voyageRepository.save(voyage);
        MessageTO message = new MessageTO("Successfully Updated Voyage with voyageNumber: " + voyageNumber);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @Transactional
    @Override
    public ResponseEntity<?> deleteVoyageById(String voyageNumber) {
        Voyage voyage = voyageRepository.findByVoyageNumber(voyageNumber)
                .orElseThrow(() ->
                        new AppException("Cannot find Voyage with voyageNumber: " + voyageNumber, HttpStatus.NOT_FOUND)
                );
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

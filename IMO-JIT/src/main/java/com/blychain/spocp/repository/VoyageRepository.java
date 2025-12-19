package com.blychain.spocp.repository;

import com.blychain.spocp.entity.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {

    Optional<Voyage> findByVoyageNumber(String voyageNumber);

    void deleteByVoyageNumber(String voyageNumber);
}

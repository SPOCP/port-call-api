package com.blychain.spocp.repository;

import com.blychain.spocp.entity.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {

    @Query("Select max(v.id) from Voyage v")
    Long findMaxId();


    Optional<Voyage> findByVoyageNumber(String voyageNumber);

    void deleteByVoyageNumber(String voyageNumber);
}

package com.blychain.spocp.repository;

import com.blychain.spocp.entity.Itinerary;
import com.blychain.spocp.entity.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    Optional<Itinerary> findByItineraryIdAndVoyage(Long itineraryId, Voyage voyage);

    @Query("SELECT COALESCE(MAX(i.itineraryId), 0) FROM Itinerary i")
    Long findMaxId();


}

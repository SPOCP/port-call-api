package com.blychain.spocp.repository;

import com.blychain.spocp.entity.PortCall;
import com.blychain.spocp.entity.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortCallRepository extends JpaRepository<PortCall, Long> {

    Optional<PortCall> findByPortCallId(Long portCallId);

    Optional<PortCall> findByPortCallIdAndVoyage(Long portCallId, Voyage voyage);

    @Query("SELECT COALESCE(MAX(p.portCallId), 0) FROM PortCall p")
    Long findMaxId();
}

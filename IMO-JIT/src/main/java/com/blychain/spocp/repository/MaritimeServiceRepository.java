package com.blychain.spocp.repository;

import com.blychain.spocp.entity.MaritimeService;
import com.blychain.spocp.entity.PortCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaritimeServiceRepository extends JpaRepository<MaritimeService, Long> {

    Optional<MaritimeService> findByMaritimeServiceIdAndPortCall(Long maritimeServiceId, PortCall portCall);

    @Query("SELECT COALESCE(MAX(ms.maritimeServiceId), 0) FROM MaritimeService ms")
    Long findMaxId();
}

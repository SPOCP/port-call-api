package com.blychain.spocp.repository;

import com.blychain.spocp.entity.MovementInPort;
import com.blychain.spocp.entity.PortCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovementInPortRepository extends JpaRepository<MovementInPort, Long> {

    Optional<MovementInPort> findByMovementInPortIdAndPortCall(Long movementInPortId, PortCall portCall);

    @Query("SELECT COALESCE(MAX(mp.movementInPortId), 0) FROM MovementInPort mp")
    Long findMaxId();
}

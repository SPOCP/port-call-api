package com.entoss.jita.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaritimeServiceStartEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime dateAndTimeOfServiceStartActual;

    private OffsetDateTime dateAndTimeOfServiceStartEstimated;

    private OffsetDateTime dateAndTimeOfServiceStartPlanned;

    private OffsetDateTime dateAndTimeOfServiceStartRequested;
}

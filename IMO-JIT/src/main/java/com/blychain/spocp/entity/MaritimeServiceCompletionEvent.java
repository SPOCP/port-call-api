package com.blychain.spocp.entity;

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
public class MaritimeServiceCompletionEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime dateAndTimeOfServiceCompletionActual;

    private OffsetDateTime dateAndTimeOfServiceCompletionEstimated;

    private OffsetDateTime dateAndTimeOfServiceCompletionPlanned;

    private OffsetDateTime dateAndTimeOfServiceCompletionRequested;
}

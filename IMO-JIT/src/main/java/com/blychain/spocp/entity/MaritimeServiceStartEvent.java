package com.blychain.spocp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_maritime_service_maritime_service_start_event",columnNames = "maritime_service_id")
})
public class MaritimeServiceStartEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime dateAndTimeOfServiceStartActual;

    private OffsetDateTime dateAndTimeOfServiceStartEstimated;

    private OffsetDateTime dateAndTimeOfServiceStartPlanned;

    private OffsetDateTime dateAndTimeOfServiceStartRequested;

    @OneToOne
    @JoinColumn(name = "maritime_service_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_maritime_service_maritime_service_start_event"))
    @JsonBackReference
    private MaritimeService maritimeService;
}

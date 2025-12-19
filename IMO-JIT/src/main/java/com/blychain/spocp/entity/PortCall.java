package com.blychain.spocp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_port_call_id", columnNames = "port_call_id")
})
public class PortCall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  An extra id(portCallId) to manage bi-directional relationship among data
    @Column(name = "port_call_id", unique = true, nullable = false)
    private Long portCallId;

    @Column(length = 17)
    private String portFacilityCoded;

    @Column(length = 256)
    private String portFacilityName;

    @Column(length = 35)
    private String shipStayReferenceNumber;

    private OffsetDateTime dateAndTimeOfDepartureActual;

    private OffsetDateTime dateAndTimeOfDepartureEstimated;

    private OffsetDateTime dateAndTimeOfDeparturePlanned;

    private OffsetDateTime dateAndTimeOfDepartureRequested;

    @Column(length = 5)
    private String portOfDepartureCoded;

    @Column(length = 256)
    private String portOfDepartureName;

    private OffsetDateTime dateAndTimeOfArrivalActual;

    private OffsetDateTime dateAndTimeOfArrivalEstimated;

    private OffsetDateTime dateAndTimeOfArrivalPlanned;

    private OffsetDateTime dateAndTimeOfArrivalRequested;

    @Column(length = 5)
    private String portOfArrivalCoded;

    @Column(length = 256)
    private String portOfArrivalName;

    @OneToOne(mappedBy = "portCall", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private AgentAtPort agentAtPort;

    @OneToOne(mappedBy = "portCall", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private PrimaryPurposesOfCall primaryPurposesOfCall;

    @Builder.Default
    @OneToMany(mappedBy = "portCall", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MovementInPort> movementInPort = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portCall", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MaritimeService> maritimeService = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "voyage_id", foreignKey = @ForeignKey(name = "fk_itinerary_voyage"))
    @JsonBackReference
    private Voyage voyage;
}

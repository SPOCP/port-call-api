package com.blychain.spocp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_port_call_agent_At_port",
                        columnNames = "agent_at_port_id"),
                @UniqueConstraint(name = "uk_port_call_primary_purpose_of_call",
                        columnNames = "primary_purposes_of_call_id")
        }
)
public class PortCall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_at_port_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_port_call_agent_At_port"))
    private AgentAtPort agentAtPort;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_purposes_of_call_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_port_call_primary_purpose_of_call"))
    private PrimaryPurposesOfCall primaryPurposesOfCall;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "port_call_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_movement_in_port_port_call"))
    private List<MovementInPort> movementInPort;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "port_call_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_maritime_service_port_call"))
    private List<MaritimeService> maritimeService;
}

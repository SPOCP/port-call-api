package com.blychain.spocp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
        @UniqueConstraint(name = "uk_movement_in_port_id", columnNames = "movement_in_port_id")
})
public class MovementInPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  An extra id(movementInPortId) to manage bi-directional relationship among data
    @Column(name = "movement_in_port_id", unique = true, nullable = false)
    private Long movementInPortId;

    private OffsetDateTime dateAndTimeToLocationInPortActual;

    private OffsetDateTime dateAndTimeToLocationInPortEstimated;

    private OffsetDateTime dateAndTimeToLocationInPortRequested;

    private OffsetDateTime dateAndTimeToLocationInPortPlanned;

    @OneToOne(mappedBy = "movementInPort", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private MovementInPortLocation movementInPortLocation;

    @ManyToOne
    @JoinColumn(name = "port_call_id", foreignKey = @ForeignKey(name = "fk_movement_in_port_port_call"))
    @JsonBackReference
    private PortCall portCall;

}

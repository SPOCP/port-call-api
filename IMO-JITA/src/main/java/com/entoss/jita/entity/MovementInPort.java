package com.entoss.jita.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_movement_in_port_movement_in_port_location",
                        columnNames = "movement_in_port_location_id")
        }
)
public class MovementInPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime dateAndTimeToLocationInPortActual;

    private OffsetDateTime dateAndTimeToLocationInPortEstimated;

    private OffsetDateTime dateAndTimeToLocationInPortRequested;

    private OffsetDateTime dateAndTimeToLocationInPortPlanned;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movement_in_port_location_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_movement_in_port_movement_in_port_location"))
    private MovementInPortLocation movementInPortLocation;
}

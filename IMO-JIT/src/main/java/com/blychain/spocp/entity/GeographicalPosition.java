package com.blychain.spocp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_geographical_position_movement_in_port_location", columnNames = "movement_in_port_location_id")
})
public class GeographicalPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String locationInPortLatitude;

    @Column(length = 11)
    private String locationInPortLongitude;

    @OneToOne
    @JoinColumn(name = "movement_in_port_location_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_geographical_position_movement_in_port_location"))
    @JsonBackReference
    private MovementInPortLocation movementInPortLocation;
}

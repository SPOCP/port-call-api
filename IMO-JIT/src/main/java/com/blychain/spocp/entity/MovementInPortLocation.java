package com.blychain.spocp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_movement_in_port_movement_in_port_location",
                        columnNames = "movement_in_port_id")
        }
)
public class MovementInPortLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256)
    private String terminalName;

    @Column(length = 256)
    private String terminalCoded;

    @Column(length = 256)
    private String pilotBoardingPlaceName;

    @Column(length = 256)
    private String berthName;

    @Column(length = 256)
    private String berthCoded;

    @Column(length= 256)
    private String berthPosition;

    @Column(length = 256)
    private String anchorageName;

    @Column(length = 256)
    private String anchorageCoded;

    @OneToOne(mappedBy = "movementInPortLocation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private GeographicalPosition geographicalPosition;


    @OneToOne
    @JoinColumn(name = "movement_in_port_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_movement_in_port_movement_in_port_location"))
    @JsonBackReference
    private MovementInPort movementInPort;


}

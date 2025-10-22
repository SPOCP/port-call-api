package com.entoss.jita.entity;

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
                @UniqueConstraint(name = "uk_movement_in_port_location_geographical_position",
                        columnNames = "geographical_position_id")
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

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "geographical_position_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_movement_in_port_location_geographical_position"))
    private GeographicalPosition geographicalPosition;
}

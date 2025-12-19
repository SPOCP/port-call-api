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
        @UniqueConstraint(name = "uk_ship_voyage", columnNames = "voyage_id")
})
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 7)
    private String shipCallSign;

    @Column(length = 7, name = "ship_imo_number")
    private String shipIMONumber;

    @Column(name = "ship_mmsi_number")
    private Integer shipMMSINumber;

    @Column(length = 70)
    private String shipName;

    @OneToOne
    @JoinColumn(name = "voyage_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_voyage_ship"))
    @JsonBackReference
    private Voyage voyage;
}

package com.entoss.jita.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 7)
    private String shipCallSign;

    @Column(length = 7,name = "ship_imo_number")
    private String shipIMONumber;

    //    @Size(max = 9)
    @Column(name = "ship_mmsi_number")
    private Integer shipMMSINumber;

    @Column(length = 70)
    private String shipName;
}

package com.blychain.spocp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_voyage_ship",
                        columnNames = "ship_id"),
                @UniqueConstraint(name = "uk_voyage_number",columnNames = "voyage_number")
        }
)
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 17, unique = true, name = "voyage_number")
    private String voyageNumber;

    @Column(length = 17)
    private String tradeIdentifierService;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "voyage_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_port_call_voyage"))
    private List<PortCall> portCall;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "voyage_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_itinerary_voyage"))
    private List<Itinerary> itinerary;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_voyage_ship"))
    private Ship ship;
}

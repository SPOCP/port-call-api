package com.blychain.spocp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_voyage_number", columnNames = "voyage_number")
        }
)
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 17, unique = true, name = "voyage_number")
    private String voyageNumber;

    @Column(length = 17)
    private String tradeServiceIdentifier;

    @Builder.Default
    @OneToMany(mappedBy = "voyage", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PortCall> portCall = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "voyage", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Itinerary> itinerary = new ArrayList<>();

    @OneToOne(mappedBy = "voyage", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Ship ship;
}

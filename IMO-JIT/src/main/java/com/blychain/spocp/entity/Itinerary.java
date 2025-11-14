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
        @UniqueConstraint(name = "uk_itinerary_id", columnNames = "itinerary_id")
})
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    An extra id(itineraryId) to manage bi-directional relationship among data
    @Column(name = "itinerary_id", unique = true, nullable = false)
    private Long itineraryId;

    private Integer portOfCallSequenceNumber;

    private Integer distanceToDestination;

    @ManyToOne
    @JoinColumn(name = "voyage_id", foreignKey = @ForeignKey(name = "fk_itinerary_voyage"))
    @JsonBackReference
    private Voyage voyage;


}

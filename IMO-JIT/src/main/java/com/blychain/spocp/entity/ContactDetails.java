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
                @UniqueConstraint(name = "uk_maritime_service_contact_details", columnNames = "maritime_service_id")
        })
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70)
    private String serviceProviderContactFamilyName;

    @Column(length = 70)
    private String serviceProviderContactGivenName;

    @OneToOne(mappedBy = "contactDetails", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Communication communication;

    @OneToOne
    @JoinColumn(name = "maritime_service_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_maritime_service_contact_details"))
    @JsonBackReference
    private MaritimeService maritimeService;
}

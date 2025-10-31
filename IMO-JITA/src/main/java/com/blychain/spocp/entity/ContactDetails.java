package com.blychain.spocp.entity;

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
                @UniqueConstraint(name = "uk_contact_details_communication", columnNames = "communication_id")
        }
)
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70)
    private String serviceProviderContactFamilyName;

    @Column(length = 70)
    private String serviceProviderContactGivenName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "communication_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_contact_details_communication"))
    private Communication communication;
}

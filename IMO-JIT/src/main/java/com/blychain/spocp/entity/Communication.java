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
        @UniqueConstraint(name = "uk_contact_details_communication", columnNames = "contact_details_id")
})
public class Communication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String serviceContactEmail;

    @Column(length = 50)
    private String serviceContactLandlineNumber;

    @Column(length = 50)
    private String serviceContactMobileNumber;

    @Column(length = 256, name = "service_url")
    private String serviceURL;

    @OneToOne
    @JoinColumn(name = "contact_details_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_contact_details_communication"))
    @JsonBackReference
    private ContactDetails contactDetails;
}

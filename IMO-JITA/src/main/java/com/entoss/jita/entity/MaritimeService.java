package com.entoss.jita.entity;

import com.entoss.jita.enums.ServiceCode;
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
                @UniqueConstraint(name = "uk_maritime_service_contact_details",
                        columnNames = "contact_details_id"),
                @UniqueConstraint(name = "uk_maritime_service_maritime_service_start_event",
                        columnNames = "maritime_service_start_event_id"),
                @UniqueConstraint(name = "uk_maritime_service_maritime_service_completion_event",
                        columnNames = "maritime_service_completion_event_id")
        }
)
public class MaritimeService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4)
    private ServiceCode serviceCoded;

    @Column(length = 70)
    private String serviceName;

    @Column(length = 70)
    private String serviceProviderName;

    @Column(length = 17)
    private String serviceBookingNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_details_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_maritime_service_contact_details"))
    private ContactDetails contactDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maritime_service_start_event_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_maritime_service_maritime_service_start_event"))
    private MaritimeServiceStartEvent maritimeServiceStartEvent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maritime_service_completion_event_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_maritime_service_maritime_service_completion_event"))
    private MaritimeServiceCompletionEvent maritimeServiceCompletionEvent;
}

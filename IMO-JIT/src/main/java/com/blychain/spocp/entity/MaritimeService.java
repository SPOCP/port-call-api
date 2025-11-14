package com.blychain.spocp.entity;

import com.blychain.spocp.enums.ServiceCode;
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
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_maritime_service_id", columnNames = "maritime_service_id")
})
public class MaritimeService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    An extra id(maritimeServiceId) to manage bi-directional relationship among data
    @Column(name = "maritime_service_id", unique = true, nullable = false)
    private Long maritimeServiceId;

    @Column(length = 4)
    private ServiceCode serviceCoded;

    @Column(length = 70)
    private String serviceName;

    @Column(length = 70)
    private String serviceProviderName;

    @Column(length = 17)
    private String serviceBookingNumber;

    @OneToOne(mappedBy = "maritimeService", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private ContactDetails contactDetails;

    @OneToOne(mappedBy = "maritimeService", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private MaritimeServiceStartEvent maritimeServiceStartEvent;

    @OneToOne(mappedBy = "maritimeService", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private MaritimeServiceCompletionEvent maritimeServiceCompletionEvent;

    @ManyToOne
    @JoinColumn(name = "port_call_id", foreignKey = @ForeignKey(name = "fk_maritime_service_port_port_call"))
    @JsonBackReference
    private PortCall portCall;


}

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
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_port_call_agent_at_port", columnNames = "port_call_id")
})
public class AgentAtPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 17)
    private String agentIdentificationNumber;

    @Column(length = 70)
    private String agentName;

    @Column(length = 70)
    private String agentContactFamilyName;

    @Column(length = 70)
    private String agentContactGivenName;

    @OneToOne(mappedBy = "agentAtPort", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private AgentAtPortCommunication agentAtPortCommunication;

    @OneToOne(mappedBy = "agentAtPort", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private AgentAtPortAddress agentAtPortAddress;

    @OneToOne
    @JoinColumn(name = "port_call_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_port_call_agent_at_port"))
    @JsonBackReference
    private PortCall portCall;

}

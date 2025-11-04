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
                @UniqueConstraint(name = "uk_agent_at_port_agent_at_port_communication", columnNames = "agent_at_port_communication_id"),
                @UniqueConstraint(name = "uk_agent_at_port_agent_at_port_address", columnNames = "agent_at_port_address_id")
        }
)
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_at_port_communication_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_agent_at_port_agent_at_port_communication"))
    private AgentAtPortCommunication agentAtPortCommunication;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_at_port_address_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_agent_at_port_agent_at_port_address"))
    private AgentAtPortAddress agentAtPortAddress;

}

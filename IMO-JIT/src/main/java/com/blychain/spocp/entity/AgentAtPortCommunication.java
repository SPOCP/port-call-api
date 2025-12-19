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
        @UniqueConstraint(name = "uk_agent_at_port_agent_at_port_communication", columnNames = "agent_at_port_id")
})
public class AgentAtPortCommunication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String agentEmail;

    @Column(length = 50)
    private String agentLandlineNumber;

    @Column(length = 50)
    private String agentMobileNumber;

    @OneToOne
    @JoinColumn(name = "agent_at_port_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_agent_at_port_agent_at_port_communication"))
    @JsonBackReference
    private AgentAtPort agentAtPort;
}

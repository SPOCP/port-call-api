package com.blychain.spocp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}

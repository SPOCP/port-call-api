package com.entoss.jita.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentAtPortAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2)
    private String agentCountryCode;

    @Column(length = 256)
    private String agentStreetAndNumber;

    @Column(length = 35)
    private String agentCity;

    @Column(length = 35)
    private String agentCountrySubDivisionName;

    @Column(length = 9)
    private String agentPostCode;

    @Column(length = 256, name = "agent_po_box")
    private String agentPOBox;
}

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
        @UniqueConstraint(name = "uk_port_call_primary_purpose_of_call", columnNames = "port_call_id")
})
public class PrimaryPurposesOfCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3)
    private String primaryPurposeOfCallCoded;

    @OneToOne
    @JoinColumn(name = "port_call_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_port_call_primary_purpose_of_call"))
    @JsonBackReference
    private PortCall portCall;

}

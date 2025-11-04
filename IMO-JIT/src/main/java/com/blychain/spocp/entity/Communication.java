package com.blychain.spocp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(length = 256,name = "service_url")
    private String serviceURL;
}

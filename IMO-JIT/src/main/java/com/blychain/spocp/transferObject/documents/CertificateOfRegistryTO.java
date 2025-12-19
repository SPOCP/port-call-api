package com.blychain.spocp.transferObject.documents;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateOfRegistryTO {

    @Schema(example = "Certificate of Registry")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "2024-02-28")
    @NotNull(message = "The date cannot be null or blank")
    private LocalDate date;

    @Schema(example = "Port Registry")
    @NotBlank(message = "The port cannot be null or blank")
    private String port;

}

package com.blychain.spocp.transferObject.documents.dangerousgoodsmanifest;

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
public class ShippingAgentDetailsTO {

    @Schema(example = "John Doe")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "Jawaharlal Nehru Port, Mumbai")
    @NotBlank(message = "The place cannot be null or blank")
    private String place;

    @Schema(example = "2024-02-15")
    @NotNull(message = "The date cannot be null")
    private LocalDate date;

    @Schema(example = "John Doe")
    @NotBlank(message = "The signature cannot be null or blank")
    private String signature;
}

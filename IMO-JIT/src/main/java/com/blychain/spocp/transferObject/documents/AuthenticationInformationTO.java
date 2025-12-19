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
public class AuthenticationInformationTO {

    @Schema(example = "2025-01-17")
    @NotNull(message = "The date cannot be null")
    private LocalDate date;

    @Schema(example = "Captain John Doe")
    @NotBlank(message = "The signature cannot be null or blank")
    private String signature;

}

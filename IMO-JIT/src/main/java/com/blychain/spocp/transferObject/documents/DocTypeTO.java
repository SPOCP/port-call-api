package com.blychain.spocp.transferObject.documents;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocTypeTO {

    @Schema(example = "true")
    @NotNull(message = "The arrival cannot be null")
    private Boolean arrival;

    @Schema(example = "false")
    @NotNull(message = "The departure cannot be null")
    private Boolean departure;

}

package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LRaftHandlingDavitTO {

    @Schema(example = "NORSAFE NDSC COMBI Davit SWL")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "2.5 mt")
    @NotBlank(message = "The size cannot be null or blank")
    private String size;
}

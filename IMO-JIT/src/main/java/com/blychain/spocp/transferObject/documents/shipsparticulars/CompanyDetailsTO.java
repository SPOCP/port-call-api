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
public class CompanyDetailsTO {

    @Schema(example = "Uni-Asia Holdings Limited")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "30/F, Prosperity Millenia Plaza, 663 King's Road, North Point, Hong Kong | T +852 2528 5016 | F +852 2528 5020")
    @NotBlank(message = "The address cannot be null or blank")
    private String address;

    @Schema(example = "www.uni-asia.com ")
    @NotBlank(message = "The website cannot be null or blank")
    private String website;
}

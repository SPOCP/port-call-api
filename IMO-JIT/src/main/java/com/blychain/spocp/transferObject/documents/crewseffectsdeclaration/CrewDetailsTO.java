package com.blychain.spocp.transferObject.documents.crewseffectsdeclaration;

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
public class CrewDetailsTO {

    @Schema(example = "Sharma")
    @NotBlank(message = "The familyName cannot be null or blank")
    private String familyName;

    @Schema(example = "Rakesh")
    @NotBlank(message = "The givenNames cannot be null or blank")
    private String givenNames;

    @Schema(example = "Master")
    @NotBlank(message = "The rankOrRating cannot be null or blank")
    private String rankOrRating;

    @Schema(example = "No")
    @NotBlank(message = "The effectsIneligible cannot be null or blank")
    private String effectsIneligible;

    @Schema(example = "Rakesh Sharma")
    @NotBlank(message = "The signature cannot be null or blank")
    private String signature;
}

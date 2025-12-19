package com.blychain.spocp.transferObject.documents.crewlist;

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
public class CrewMembersTO {

    @Schema(example = "Sharma")
    @NotBlank(message = "The familyName cannot be null or blank")
    private String familyName;

    @Schema(example = "Rakesh")
    @NotBlank(message = "The givenNames cannot be null or blank")
    private String givenNames;

    @Schema(example = "Master")
    @NotBlank(message = "The rankOrRating cannot be null or blank")
    private String rankOrRating;

    @Schema(example = "India")
    @NotBlank(message = "The nationality cannot be null or blank")
    private String nationality;

    @Schema(example = "1990-05-15")
    @NotNull(message = "The dateOfBirth cannot be null")
    private LocalDate dateOfBirth;

    @Schema(example = "Mumbai")
    @NotBlank(message = "The placeOfBirth cannot be null or blank")
    private String placeOfBirth;

    @Schema(example = "Male")
    @NotBlank(message = "The gender cannot be null or blank")
    private String gender;

    @Schema(example = "Passport")
    @NotBlank(message = "The natureOfIdentityDocument cannot be null or blank")
    private String natureOfIdentityDocument;

    @Schema(example = "IN1234567")
    @NotBlank(message = "The identityDocumentNumber cannot be null or blank")
    private String identityDocumentNumber;

    @Schema(example = "India")
    @NotBlank(message = "The issuingStateOfIdentityDocument cannot be null or blank")
    private String issuingStateOfIdentityDocument;

    @Schema(example = "2026-05-15")
    @NotNull(message = "The expiryDateOfIdentityDocument cannot be null")
    private LocalDate expiryDateOfIdentityDocument;
}

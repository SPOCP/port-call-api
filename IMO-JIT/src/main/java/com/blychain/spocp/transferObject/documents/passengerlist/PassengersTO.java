package com.blychain.spocp.transferObject.documents.passengerlist;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengersTO {

    @Schema(example = "Singh")
    @NotBlank(message = "The familyName cannot be null or blank")
    private String familyName;

    @Schema(example = "Rajesh")
    @NotBlank(message = "The givenNames cannot be null or blank")
    private String givenNames;

    @Schema(example = "India")
    @NotBlank(message = "The nationality cannot be null or blank")
    private String nationality;

    @Schema(example = "1996-08-25")
    @NotNull(message = "The dateOfBirth cannot be null")
    private LocalDate dateOfBirth;

    @Schema(example = "Mumbai")
    @NotBlank(message = "The placeOfBirth cannot be null or blank")
    private String placeOfBirth;

    @Schema(example = "Male")
    @NotBlank(message = "The gender cannot be null or blank")
    private String gender;

    @Schema(example = "Passport")
    @NotBlank(message = "The typeOfIdentity cannot be null or blank")
    private String typeOfIdentity;

    @Schema(example = "IND654321")
    @NotBlank(message = "The serialNumberOfIdentity cannot be null or blank")
    private String serialNumberOfIdentity;

    @Schema(example = "India")
    @NotBlank(message = "The issuingStateOfIdentity cannot be null or blank")
    private String issuingStateOfIdentity;

    @Schema(example = "2029-08-25")
    @NotNull(message = "The expiryDateOfIdentity cannot be null")
    private LocalDate expiryDateOfIdentity;

    @Schema(example = "Jawaharlal Nehru Port, India")
    @NotBlank(message = "The embarkationPort cannot be null or blank")
    private String embarkationPort;

    @Schema(example = "Mundra Port, India")
    @NotBlank(message = "The disembarkationPort cannot be null or blank")
    private String disembarkationPort;

    @Schema(example = "IND3456")
    @NotBlank(message = "The visaNumber cannot be null or blank")
    private String visaNumber;

    @Schema(example = "true")
    @NotNull(message = "The transitPassenger cannot be null")
    private Boolean transitPassenger;
}


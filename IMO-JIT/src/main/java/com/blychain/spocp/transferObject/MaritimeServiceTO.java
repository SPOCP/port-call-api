package com.blychain.spocp.transferObject;

import com.blychain.spocp.enums.ServiceCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaritimeServiceTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long maritimeServiceId;

    @Schema(example = "CRGO")
    @NotNull(message = "MaritimeService - serviceCoded cannot be null.")
    private ServiceCode serviceCoded;

    @Schema(example = "Container cargo operations")
    @NotBlank(message = "MaritimeService - serviceName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .()&'-]+$",
            message = "MaritimeService - serviceName: Invalid value. Please check the field format."
    )
    @Size(max = 70, message = "The length of MaritimeService - serviceName cannot be more than 70.")
    private String serviceName;


    @Schema(example = "MarineCargo India Pvt. Ltd")
    @NotBlank(message = "MaritimeService - serviceProviderName cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9 .,&'()/-]+$",
            message = "MaritimeService - serviceProviderName: Invalid value. Please check the field format."
    )
    @Size(max = 70, message = "The length of MaritimeService - serviceProviderName cannot be more than 70.")
    private String serviceProviderName;


    @Schema(example = "CARGO-20250612")
    @NotBlank(message = "MaritimeService - serviceBookingNumber cannot be null.")
    @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "MaritimeService - serviceBookingNumber: Invalid value. Please check the field format."
    )
    @Size(max = 17, message = "The length of MaritimeService - serviceBookingNumber cannot be more than 17.")
    private String serviceBookingNumber;


    @Valid
    private ContactDetailsTO contactDetails;

    @Valid
    private MaritimeServiceStartEventTO maritimeServiceStartEvent;

    @Valid
    private MaritimeServiceCompletionEventTO maritimeServiceCompletionEvent;
}

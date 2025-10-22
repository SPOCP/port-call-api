package com.entoss.jita.transferObject;

import com.entoss.jita.enums.ServiceCode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaritimeServiceTO {
    @Schema(example = "CRGO")
//    @Size(max = 4, message = "The length of serviceCoded cannot be more than 4")
    private ServiceCode serviceCoded;

    @Schema(example = "Container cargo operations")
    @Size(max = 70, message = "The length of serviceName cannot be more than 70")
    private String serviceName;

    @Schema(example = "MarineCargo India Pvt. Ltd")
    @Size(max = 70, message = "The length of serviceProviderName cannot be more than 70")
    private String serviceProviderName;

    @Schema(example = "CARGO-20250612")
    @Size(max = 17, message = "The length of serviceBookingNumber cannot be more than 17")
    private String serviceBookingNumber;

    @Valid
    private ContactDetailsTO contactDetails;

    @Valid
    private MaritimeServiceStartEventTO maritimeServiceStartEvent;

    @Valid
    private MaritimeServiceCompletionEventTO maritimeServiceCompletionEvent;
}

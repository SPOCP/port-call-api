package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageTO {

    @Schema(example = "Successfully Updated Voyage with voyageNumber: VC000001")
    private String message;
}

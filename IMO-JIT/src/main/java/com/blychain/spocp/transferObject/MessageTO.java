package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageTO {

    @Schema(example = "Successfully Updated Voyage with voyageNumber: VN20250612-MUMDXB")
    private String message;
}

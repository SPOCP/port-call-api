package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseTO {

    private LocalDateTime timestamp;

    @Schema(example = "404")
    private Integer status;

    @Schema(example = "NOT FOUND")
    private String error;

    @Schema(example = "Voyage Not Found with voyageNumber : VN20250619-MUMDXB")
    private String message;
}

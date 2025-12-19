package com.blychain.spocp.transferObject.documents;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DateAndTimeTO {

    @Schema(example = "2024-02-29T10:30:00+05:30")
    @NotNull(message = "The actual cannot be null")
    private OffsetDateTime actual;

    @Schema(example = "2024-02-29T10:30:00+05:30")
    @NotNull(message = "The estimated cannot be null")
    private OffsetDateTime estimated;

}

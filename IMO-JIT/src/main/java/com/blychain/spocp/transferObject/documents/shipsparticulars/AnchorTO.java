package com.blychain.spocp.transferObject.documents.shipsparticulars;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnchorTO {

    @Schema(example = "2")
    @NotNull(message = "The fwt cannot be null")
    private Integer fwt;

    @Schema(example = "3")
    @NotNull(message = "The aft cannot be null or blank")
    private Integer aft;

    @Schema(example = "AC-14 Type, 6620 kg x 2 sets")
    @NotBlank(message = "The particulars cannot be null or blank")
    private String particulars;
}

package com.blychain.spocp.transferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomPdfResponseTO {

    @Schema(example = "IMO_GeneralDeclaration_1111111111111.pdf")
    private String fileName;

    @Schema(example = "success")
    private String status;

    @Schema(example = "PDF generated successfully.")
    private String message;

    @Schema(example = "/imo/doc?pdfName=IMO_GeneralDeclaration_1111111111111.pdf")
    private String getUrl;

}

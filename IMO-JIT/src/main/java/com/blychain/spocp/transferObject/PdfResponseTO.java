package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PdfResponseTO {
    private Data data;
    private String status;
    private String message;

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String id;
        private String revId;
        private String fileName;
        private String path;

    }
}

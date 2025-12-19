package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;

@Hidden
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PortListTO {

    private Integer id;

    @JsonProperty("name")
    private String portName;

    @JsonProperty("port_code")
    private String portCode;

}

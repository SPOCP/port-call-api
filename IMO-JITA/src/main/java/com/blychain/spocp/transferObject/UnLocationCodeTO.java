package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;

@Hidden
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnLocationCodeTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("un_location_code")
    private String unLocationCode;

    @JsonProperty("un_location_name")
    private String unLocationName;

    @JsonProperty("location_code")
    private String locationCode;

    @JsonProperty("country_code")
    private String countryCode;

}

package com.blychain.spocp.transferObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;

@Hidden
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryCodeTO {

    private Integer id;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;
}

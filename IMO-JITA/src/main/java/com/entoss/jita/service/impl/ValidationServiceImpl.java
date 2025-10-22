package com.entoss.jita.service.impl;

import com.entoss.jita.enums.ServiceCode;
import com.entoss.jita.exception.AppException;
import com.entoss.jita.transferObject.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl {

    @Value("${master-data.baseUrl}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public void validateInformation(VoyageTO voyageTO) {
        if (voyageTO.getPortCall() == null) {
            return;
        }

        for (PortCallTO portCallTO : voyageTO.getPortCall()) {
//            Departure Code
            validatePortCode(portCallTO.getPortOfDepartureCoded(), portCallTO.getPortOfDepartureName());

//            Arrival Code
            validatePortCode(portCallTO.getPortOfArrivalCoded(), portCallTO.getPortOfArrivalName());

//            Country Code
            validateAgentCountry(portCallTO);

            if (portCallTO.getMaritimeService() != null) {
                validateMaritimeService(portCallTO.getMaritimeService());
            }

        }
    }

    private void validateMaritimeService(List<MaritimeServiceTO> maritimeService) {
        for (MaritimeServiceTO ms : maritimeService) {
            if (ms.getServiceCoded() != null) {
                ServiceCode serviceCoded = ms.getServiceCoded();

                if (ms.getServiceName() != null) {
                    String name = serviceCoded.getName();
                    if (!ms.getServiceName().equals(name)) {
                        throw new AppException(String.format("Wrong ServiceName : %s for ServiceCode : %s", ms.getServiceName(), ms.getServiceCoded()), HttpStatus.BAD_REQUEST);
                    }
                }
            }
        }
    }

    private void validatePortCode(String coded, String name) {
        if (coded == null) return;

        String validationMessage = validateUnLocationData(coded, name);
        if (validationMessage != null) {
            throw new AppException(validationMessage, HttpStatus.BAD_REQUEST);
        }
    }

    private void validateAgentCountry(PortCallTO portCallTO) {
        if (portCallTO.getAgentAtPort() == null) return;
        if (portCallTO.getAgentAtPort().getAgentAtPortAddress() == null) return;

        String countryCode = portCallTO.getAgentAtPort().getAgentAtPortAddress().getAgentCountryCode();
        if (countryCode != null) {
            String validationMessage = validateCountryData(countryCode);
            if (validationMessage != null) {
                throw new AppException(validationMessage, HttpStatus.BAD_REQUEST);
            }

        }
    }


    private String validateCountryData(String countryCode) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("tableName", "country")
                .queryParam("countryCode", countryCode);

        String apiUrl = uriBuilder.toUriString();

        try {
            ResponseEntity<List<CountryCodeTO>> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<CountryCodeTO>>() {
                    }
            );


            List<CountryCodeTO> body = Optional.ofNullable(response.getBody()).orElse(Collections.emptyList());

            if (body.isEmpty()) {
                return "Invalid data provided for countryCode : " + countryCode;
            }

        } catch (RestClientException ex) {
            throw new AppException("Unable to validate countryCode due to external service error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null; // means valid
    }

    private String validateUnLocationData(String unlocationCode, String locationName) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("tableName", "unlocation")
                .queryParam("unlocationCode", unlocationCode);

        if (locationName != null && !locationName.isBlank()) {
            uriBuilder.queryParam("unLocationName", locationName); // No need to encode manually
        }

        URI uri = uriBuilder.encode().build().toUri();

        try {
            ResponseEntity<List<UnLocationCodeTO>> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UnLocationCodeTO>>() {
                    }
            );

            List<UnLocationCodeTO> body = Optional.ofNullable(response.getBody()).orElse(Collections.emptyList());

            if (body.isEmpty()) {
                if (locationName != null) {
                    return String.format("Invalid data provided for UnLocationCode : %s and LocationName : %s.", unlocationCode, locationName);
                } else {
                    return String.format("Invalid data provided for UnLocationCode : %s.", unlocationCode);
                }
            }


        } catch (RestClientException ex) {
            throw new AppException("Unable to validate UnLocationCode due to external service error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null; // valid
    }


}

package com.blychain.spocp.service.impl;

import com.blychain.spocp.enums.ServiceCode;
import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.transferObject.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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

    @Value("${auth.username}")
    private String username;

    @Value("${auth.password}")
    private String password;

    private final RestTemplate restTemplate;

    /**
     * Validates the provided VoyageTO object.
     * Performs recursive validation for nested PortCall and MaritimeService data.
     */
    public void validateInformation(VoyageTO voyageTO) {

//        Skip validation if no PortCall data is present
        if (voyageTO.getPortCall() == null) {
            return;
        }

//        Validate each PortCall object
        if (!voyageTO.getPortCall().isEmpty()) {
            for (PortCallTO portCallTO : voyageTO.getPortCall()) {
                validatePortCall(portCallTO);
            }
        }
    }

    /**
     * Validates individual PortCall object.
     * Ensures correctness of port codes, country codes, and maritime services.
     */
    public void validatePortCall(PortCallTO portCallTO) {

//        Validate Port of Departure (Code and Name)
        validatePortCode(portCallTO.getPortOfDepartureCoded(), portCallTO.getPortOfDepartureName());

//        Validate Port of Arrival (Code and Name)
        validatePortCode(portCallTO.getPortOfArrivalCoded(), portCallTO.getPortOfArrivalName());

//        Validate Agent Country Code if Agent details are present
        if (portCallTO.getAgentAtPort() != null &&
                portCallTO.getAgentAtPort().getAgentAtPortAddress() != null) {
            validateAgentCountry(portCallTO);
        }

//        Validate each Maritime Service if present
        if (!portCallTO.getMaritimeService().isEmpty()) {
            for (MaritimeServiceTO maritimeServiceTO : portCallTO.getMaritimeService()) {
                validateMaritimeService(maritimeServiceTO);
            }
        }
    }

    /**
     * Validates MaritimeService object.
     * Ensures ServiceName matches the expected value for the given ServiceCode.
     */
    public void validateMaritimeService(MaritimeServiceTO maritimeService) {

//        Proceed only if ServiceCode is provided
        if (maritimeService.getServiceCoded() != null) {
            ServiceCode serviceCoded = maritimeService.getServiceCoded();

//        Validate ServiceName if both code and name are provided
            if (maritimeService.getServiceName() != null) {
                String name = serviceCoded.getName();
                if (!maritimeService.getServiceName().equals(name)) {
                    throw new AppException(
                            String.format("Wrong ServiceName : %s for ServiceCode : %s",
                                    maritimeService.getServiceName(), maritimeService.getServiceCoded()),
                            HttpStatus.BAD_REQUEST
                    );
                }
            }
        }
    }

    /**
     * Validates a given PortCode and PortName against Master Data.
     */
    private void validatePortCode(String coded, String name) {
        if (coded == null) return;

//        String validationMessage = validateUnLocationData(coded, name);
        String validationMessage = validatePortData(coded, name);
        if (validationMessage != null) {
            throw new AppException(validationMessage, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Validates the country code of an AgentAtPort against Master Data.
     */
    private void validateAgentCountry(PortCallTO portCallTO) {

        String countryCode = portCallTO.getAgentAtPort().getAgentAtPortAddress().getAgentCountryCode();

        if (countryCode != null) {
            String validationMessage = validateCountryData(countryCode);
            if (validationMessage != null) {
                throw new AppException(validationMessage, HttpStatus.BAD_REQUEST);
            }
        }
    }

    /**
     * Calls external Master Data API to validate a given CountryCode.
     * countryCode The country code to validate.
     * Null if valid, or error message if invalid.
     */
    private String validateCountryData(String countryCode) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("tableName", "country")
                .queryParam("countryCode", countryCode);

        HttpHeaders headers = new HttpHeaders();
        headers.set("username", username);
        headers.set("password", password);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String apiUrl = uriBuilder.toUriString();

        try {
//            Call Master Data Service for country validation
            ResponseEntity<List<CountryCodeTO>> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<CountryCodeTO>>() {
                    }
            );

//            Extract response body
            List<CountryCodeTO> body = Optional.ofNullable(response.getBody()).orElse(Collections.emptyList());

//            Return error message if invalid
            if (body.isEmpty()) {
                return "Invalid data provided for countryCode : " + countryCode;
            }

        } catch (RestClientException ex) {
            throw new AppException("Unable to validate countryCode due to external service error." + ex,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return null; // Valid
    }


    /**
     * Calls external Master Data API to validate a given Port Code and Name.
     * portCode The UN location code to validate.
     * portName   The corresponding location name.
     * Null if valid, or error message if invalid.
     */
    private String validatePortData(String portCode, String portName) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("tableName", "portList")
                .queryParam("portCode", portCode);

        if (portName != null && !portName.isBlank()) {
            uriBuilder.queryParam("portName", portName);
        }

        URI uri = uriBuilder.encode().build().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("username", username);
        headers.set("password", password);

        HttpEntity<Void> entity = new HttpEntity<>(headers);


        try {
//            Call Master Data Service for Port Code
            ResponseEntity<List<PortListTO>> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<PortListTO>>() {
                    }
            );

//            Extract response body
            List<PortListTO> body = Optional.ofNullable(response.getBody()).orElse(Collections.emptyList());

//            Return error message if no valid records found
            if (body.isEmpty()) {
                if (portName != null) {
                    return String.format("Invalid data provided for portCode : %s and portName : %s.",
                            portCode, portName);
                } else {
                    return String.format("Invalid data provided for portCode : %s.", portCode);
                }
            }

        }
        catch (HttpClientErrorException.Unauthorized ex) {
            // 401
            throw new AppException(
                    "Invalid credentials to validate the data, Please Register to Pomfret Console",
                    HttpStatus.UNAUTHORIZED
            );
        }
        catch (RestClientException ex) {
            throw new AppException("Unable to validate portCode due to external service error." + ex,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return null; // Valid
    }

}

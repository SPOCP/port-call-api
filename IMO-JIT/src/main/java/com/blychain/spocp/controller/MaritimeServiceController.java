package com.blychain.spocp.controller;

import com.blychain.spocp.service.MaritimeServiceService;
import com.blychain.spocp.transferObject.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portcall/{portCallId}/maritime-service")
@RequiredArgsConstructor
@Tag(name = "Maritime-Service API", description = "Maritime-Service operations")
public class MaritimeServiceController {

    //    Service
    private final MaritimeServiceService maritimeServiceService;

    @PostMapping
    @Operation(summary = "Create Maritime-Service",
            description = """
                    Create a new Maritime-Service for a particular Port-Call
                            
                    - Request body must contain valid **MaritimeService** Payload
                                        
                    - **portCallId** (path variable) is **mandatory**
                            
                    - Returns **201** on success   
                            
                    - Possible errors: **400** (Bad Request), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaritimeServiceTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> createMaritimeService(@PathVariable Long portCallId, @Valid @RequestBody MaritimeServiceTO maritimeServiceTO) {
        return maritimeServiceService.createMaritimeService(portCallId, maritimeServiceTO);
    }


    @GetMapping("/{maritimeServiceId}")
    @Operation(summary = "Get Maritime-Service",
            description = """
                    Get a Maritime-Service by portCallId and maritimeServiceId
                                        
                    - **portCallId** (path variable) is **mandatory**
                                        
                    - **maritimeServiceId** (path variable) is **mandatory**
                            
                    - Returns **200** on success   
                            
                    - Possible errors: **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Retrieved",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MaritimeServiceTO.class)
                            )),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> getMaritimeServiceById(@PathVariable Long portCallId, @PathVariable Long maritimeServiceId) {
        return maritimeServiceService.getMaritimeServiceById(portCallId, maritimeServiceId);
    }


    @PutMapping("/{maritimeServiceId}")
    @Operation(summary = "Update Maritime-Service",
            description = """
                    Update a Maritime-Service by voyageNumber and maritimeServiceId
                            
                    - Request body must contain valid **MaritimeService** Payload
                                        
                    - **portCallId** (path variable) is **mandatory**
                                        
                    - **maritimeServiceId** (path variable) is **mandatory**
                            
                    - Returns **202** on success  
                            
                    - Possible errors: **400** (Bad Request), **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Successful Accepted",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaritimeServiceTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> updateMaritimeServiceById(@PathVariable Long portCallId, @PathVariable Long maritimeServiceId, @Valid @RequestBody MaritimeServiceTO maritimeServiceTO) {
        return maritimeServiceService.updateMaritimeServiceById(portCallId, maritimeServiceId, maritimeServiceTO);
    }


    @DeleteMapping("{maritimeServiceId}")
    @Operation(summary = "Delete Maritime-Service",
            description = """
                    Delete a Maritime-Service by voyageNumber and maritimeServiceId
                            
                    - **portCallId** (path variable) is **mandatory**
                                        
                     - **maritimeServiceId** (path variable) is **mandatory**
                            
                    - Returns **202** on success   
                            
                    - Possible errors: **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Successful Deleted",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> deleteMaritimeServiceById(@PathVariable Long portCallId, @PathVariable Long maritimeServiceId) {
        return maritimeServiceService.deleteMaritimeServiceById(portCallId, maritimeServiceId);
    }
}

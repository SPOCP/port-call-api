package com.blychain.spocp.controller;

import com.blychain.spocp.service.MovementInPortService;
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
@RequestMapping("/portcall/{portCallId}/movement-in-port")
@RequiredArgsConstructor
@Tag(name = "Movement-In-Port API", description = "Movement-In-Port operations")
public class MovementInPortController {

    //    Service
    private final MovementInPortService movementInPortService;

    @PostMapping
    @Operation(summary = "Create Movement-In-Port",
            description = """
                    Create a new Movement-In-Port for a particular Port-Call
                            
                    - Request body must contain valid **MovementInPort** Payload
                                        
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
    public ResponseEntity<?> createMovementInPort(@PathVariable Long portCallId, @Valid @RequestBody MovementInPortTO movementInPortTO) {
        return movementInPortService.createMovementInPort(portCallId, movementInPortTO);
    }


    @GetMapping("/{movementInPortId}")
    @Operation(summary = "Get Movement-In-Port",
            description = """
                    Get a Movement-In-Port by portCallId and movementInPortId
                                        
                    - **portCallId** (path variable) is **mandatory**
                                        
                    - **movementInPortId** (path variable) is **mandatory**
                            
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
    public ResponseEntity<?> getMovementInPortById(@PathVariable Long portCallId, @PathVariable Long movementInPortId) {
        return movementInPortService.getMovementInPortById(portCallId, movementInPortId);
    }


    @PutMapping("/{movementInPortId}")
    @Operation(summary = "Update Movement-In-Port",
            description = """
                    Update a Movement-In-Port by portCallId and movementInPortId
                            
                    - Request body must contain valid **MovementInPort** Payload
                                        
                    - **portCallId** (path variable) is **mandatory**
                                        
                    - **movementInPortId** (path variable) is **mandatory**
                            
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
    public ResponseEntity<?> updateMovementInPortById(@PathVariable Long portCallId, @PathVariable Long movementInPortId, @Valid @RequestBody MovementInPortTO movementInPortTO) {
        return movementInPortService.updateMovementInPortById(portCallId, movementInPortId, movementInPortTO);
    }


    @DeleteMapping("{movementInPortId}")
    @Operation(summary = "Delete Movement-In-Port",
            description = """
                    Delete a Movement-In-Port by portCallId and movementInPortId
                            
                    - **portCallId** (path variable) is **mandatory**
                                        
                     - **movementInPortId** (path variable) is **mandatory**
                            
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
    public ResponseEntity<?> deleteMovementInPortById(@PathVariable Long portCallId, @PathVariable Long movementInPortId) {
        return movementInPortService.deleteMovementInPortyById(portCallId, movementInPortId);
    }
}

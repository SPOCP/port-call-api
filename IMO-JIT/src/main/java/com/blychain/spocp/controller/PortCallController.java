package com.blychain.spocp.controller;

import com.blychain.spocp.service.PortCallService;
import com.blychain.spocp.transferObject.ErrorResponseTO;
import com.blychain.spocp.transferObject.MessageTO;
import com.blychain.spocp.transferObject.PortCallTO;
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
@RequestMapping("/jit/voyage/{voyageNumber}/portcall")
@RequiredArgsConstructor
@Tag(name = "Port Call API", description = "Port-Call operations")
public class PortCallController {

    //    Service
    private final PortCallService portCallService;

    @PostMapping
    @Operation(summary = "Create Port-Call",
            description = """
                    Create a new Port-Call for a particular Voyage
                            
                    - Request body must contain valid **PortCall** Payload
                                        
                    - **voyageNumber** (path variable) is **mandatory**
                            
                    - Returns **201** on success   
                            
                    - Possible errors: **400** (Bad Request), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PortCallTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> createPortCall(@PathVariable String voyageNumber, @Valid @RequestBody PortCallTO portCallTO) {
        return portCallService.createPortCall(voyageNumber, portCallTO);
    }


    @GetMapping("/{portCallId}")
    @Operation(summary = "Get Port-Call",
            description = """
                    Get a Port-Call by voyageNumber and portCallId
                                        
                    - **voyageNumber** (path variable) is **mandatory**
                                        
                    - **portCallId** (path variable) is **mandatory**
                            
                    - Returns **200** on success   
                            
                    - Possible errors: **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Retrieved",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PortCallTO.class)
                            )),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> getPortCallById(@PathVariable String voyageNumber, @PathVariable Long portCallId) {
        return portCallService.getPortCallById(voyageNumber, portCallId);
    }


    @PutMapping("/{portCallId}")
    @Operation(summary = "Update Port-Call",
            description = """
                    Update a Port-Call by voyageNumber and portCallId
                            
                    - Request body must contain valid **PortCall** Payload
                                        
                    - **voyageNumber** (path variable) is **mandatory**
                                        
                    - **portCallId** (path variable) is **mandatory**
                            
                    - Returns **202** on success  
                            
                    - Possible errors: **400** (Bad Request), **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Successful Accepted",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PortCallTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> updatePortCallById(@PathVariable String voyageNumber, @PathVariable Long portCallId, @Valid @RequestBody PortCallTO portCallTO) {
        return portCallService.updatePortCallById(voyageNumber, portCallId, portCallTO);
    }


    @DeleteMapping("{portCallId}")
    @Operation(summary = "Delete Port-Call",
            description = """
                    Delete a Port-Call by voyageNumber and portCallId
                            
                    - **voyageNumber** (path variable) is **mandatory**
                                        
                     - **portCallId** (path variable) is **mandatory**
                            
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
    public ResponseEntity<?> deletePortCallById(@PathVariable String voyageNumber, @PathVariable Long portCallId) {
        return portCallService.deletePortCallById(voyageNumber, portCallId);
    }
}

package com.blychain.spocp.controller;

import com.blychain.spocp.service.ItineraryService;
import com.blychain.spocp.transferObject.ErrorResponseTO;
import com.blychain.spocp.transferObject.ItineraryTO;
import com.blychain.spocp.transferObject.MessageTO;
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
@RequestMapping("/jit/voyage/{voyageNumber}/itinerary")
@RequiredArgsConstructor
@Tag(name = "Itinerary API", description = "Itinerary operations")
public class ItineraryController {

    //    Service
    private final ItineraryService itineraryService;


    @PostMapping
    @Operation(summary = "Create Itinerary",
            description = """
                    Create a new Itinerary for a particular Voyage
                            
                    - Request body must contain valid **Itinerary** Payload
                                        
                    - **voyageNumber** (path variable) is **mandatory**
                            
                    - Returns **201** on success   
                            
                    - Possible errors: **400** (Bad Request), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItineraryTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> createItinerary(@PathVariable String voyageNumber, @Valid @RequestBody ItineraryTO itineraryTO) {
        return itineraryService.createItinerary(voyageNumber, itineraryTO);
    }

    @GetMapping("/{itineraryId}")
    @Operation(summary = "Get Itinerary",
            description = """
                    Get a Itinerary by voyageNumber and itineraryId
                                        
                    - **voyageNumber** (path variable) is **mandatory**
                                        
                    - **itineraryId** (path variable) is **mandatory**
                            
                    - Returns **200** on success   
                            
                    - Possible errors: **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Retrieved",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ItineraryTO.class)
                            )),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> getItineraryById(@PathVariable String voyageNumber, @PathVariable Long itineraryId) {
        return itineraryService.getItineraryById(voyageNumber, itineraryId);
    }



    @PutMapping("/{itineraryId}")
    @Operation(summary = "Update Itinerary",
            description = """
                    Update a Itinerary by voyageNumber and itineraryId
                            
                    - Request body must contain valid **Itinerary** Payload
                                        
                    - **voyageNumber** (path variable) is **mandatory**
                                        
                    - **itineraryId** (path variable) is **mandatory**
                            
                    - Returns **202** on success  
                            
                    - Possible errors: **400** (Bad Request), **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Successful Accepted",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItineraryTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> updateItineraryById(@PathVariable String voyageNumber, @PathVariable Long itineraryId,@Valid @RequestBody ItineraryTO itineraryTO) {
        return itineraryService.updateItineraryById(voyageNumber, itineraryId, itineraryTO);
    }

    @DeleteMapping("/{itineraryId}")
    @Operation(summary = "Delete Itinerary",
            description = """
                    Delete a Itinerary by voyageNumber and itineraryId
                            
                    - **voyageNumber** (path variable) is **mandatory**
                                        
                    - **itineraryId** (path variable) is **mandatory**
                            
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
    public ResponseEntity<?> deleteItineraryById(@PathVariable String voyageNumber, @PathVariable Long itineraryId) {
        return itineraryService.deleteItineraryById(voyageNumber, itineraryId);
    }


}

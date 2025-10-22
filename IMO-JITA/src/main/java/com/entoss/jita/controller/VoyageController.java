package com.entoss.jita.controller;

import com.entoss.jita.service.impl.ValidationServiceImpl;
import com.entoss.jita.service.VoyageService;
import com.entoss.jita.transferObject.ErrorResponseTO;
import com.entoss.jita.transferObject.MessageTO;
import com.entoss.jita.transferObject.VoyageTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voyage")
@RequiredArgsConstructor
@Tag(name = "Voyage API", description = "Voyage operations")
public class VoyageController {

    //Service
    private final VoyageService voyageService;

    private final ValidationServiceImpl validationService;

    //Create Voyage by Id
    @PostMapping
    @Operation(summary = "Create Voyage",
//            description = "Create a new Voyage",
            description = """
                    Create a new Voyage
                            
                    - Request body must contain valid **Voyage** Payload
                            
                    - Returns **201** on success   
                            
                    - Possible errors: **400** (Bad Request), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> createVoyage(@Valid @RequestBody VoyageTO voyageTO) {
        return voyageService.createVoyage(voyageTO);
    }


    @GetMapping("/{voyageNumber}")
    @Operation(summary = "Get Voyage",
//            description = "Get Voyage by ID",
            description = """
                    Get a Voyage by voyageNumber
                                        
                    - **voyageNumber** (path variable) is **mandatory**
                            
                    - Returns **200** on success   
                            
                    - Possible errors: **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Retrieved",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VoyageTO.class)
                            )),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> getVoyageById(@PathVariable String voyageNumber) {
        return voyageService.getVoyageById(voyageNumber);
    }


    @PutMapping("/{voyageNumber}")
    @Operation(summary = "Update Voyage",
//            description = "Update Voyage by ID",
            description = """
                    Update a Voyage by voyageNumber
                            
                    - Request body must contain valid **Voyage** Payload
                                        
                    - **voyageNumber** (path variable) is **mandatory**
                            
                    - Returns **202** on success  
                            
                    - Possible errors: **400** (Bad Request), **404** (Not Found), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Successful Accepted",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    public ResponseEntity<?> updateVoyageById(@PathVariable String voyageNumber, @Valid @RequestBody VoyageTO voyageTO) {
        return voyageService.updateVoyageById(voyageNumber, voyageTO);
    }


    @DeleteMapping("/{voyageNumber}")
    @Operation(summary = "Delete Voyage",
//            description = "Delete Voyage by ID",
            description = """
                    Delete a Voyage by voyageNumber  
                            
                    - **voyageNumber** (path variable) is **mandatory**
                            
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
    public ResponseEntity<?> deleteVoyageById(@PathVariable String voyageNumber) {
        return voyageService.deleteVoyageById(voyageNumber);
    }


    // eg - port-call?page=0&size=20&sort=id,desc
    @GetMapping
    @Operation(summary = "Get All Voyages",
//            description = "Returns a list of all Voyages",
            description = """
                    Create a new Voyage
                            
                    - Request body must contain valid **Voyage** Payload
                            
                    - Returns **200** on success if cancellation is processed  
                            
                    - Possible errors: **400** (Bad Request), **500** (Internal Server Error)  
                    """,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Retrieved",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VoyageTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class)))
            }
    )
    @ResponseStatus(value = HttpStatus.OK)
    public PagedModel<?> getAllVoyage(Pageable pageable) {
        return voyageService.getAllVoyage(pageable);

    }

}

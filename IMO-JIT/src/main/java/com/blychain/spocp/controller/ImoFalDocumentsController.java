package com.blychain.spocp.controller;

import com.blychain.spocp.service.ImoFalDocumentsService;
import com.blychain.spocp.transferObject.CustomPdfResponseTO;
import com.blychain.spocp.transferObject.ErrorResponseTO;
import com.blychain.spocp.transferObject.documents.cargodeclaration.CargoDeclarationTO;
import com.blychain.spocp.transferObject.documents.crewlist.CrewListTO;
import com.blychain.spocp.transferObject.documents.crewseffectsdeclaration.CrewsEffectsDeclarationTO;
import com.blychain.spocp.transferObject.documents.dangerousgoodsmanifest.DangerousGoodsManifestTO;
import com.blychain.spocp.transferObject.documents.generaldeclaration.GeneralDeclarationTO;
import com.blychain.spocp.transferObject.documents.passengerlist.PassengerListTO;
import com.blychain.spocp.transferObject.documents.shipsparticulars.ShipsDetailsTO;
import com.blychain.spocp.transferObject.documents.shipsstore.ShipsStoreDeclarationTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doc")
@Tag(name = "Documents API", description = "Documents operations")
public class ImoFalDocumentsController {

    //    Service
    private final ImoFalDocumentsService imoFalDocumentsService;


    //    GENERAL DECLARATION
    @PostMapping("/general-declaration")
    @Operation(
            summary = "General Declaration",
            description = """
                    This endpoint is used to generate the IMO General Declaration document.
                                        
                    All the fields are **mandatory** while generating the pdf.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "General  Declaration",
                                    value = """
                                            {
                                               "docType": {
                                                 "arrival": true,
                                                 "departure": false
                                               },
                                               "authenticationInformation": {
                                                 "date": "2024-02-29",
                                                 "signature": "Captain John Doe"
                                               },
                                               "voyageInformation": {
                                                 "nameOfShip": "Ocean Voyager",
                                                 "typeOfShip": "Container Ship",
                                                 "imoNumber": "IMO9876543",
                                                 "callSign": "VTAB",
                                                 "voyageNumber": "OV-IND-0224",
                                                 "netTonnage": 1500,
                                                 "grossTonnage": 2000,
                                                 "flagState": "India",
                                                 "numberOfCrew": 20,
                                                 "numberOfPassengers": 12,
                                                 "briefDescriptionOfTheCargo": "Containerized cargo consisting of engineering goods, electronics, and consumer products.",
                                                 "currentPort": "Jawaharlal Nehru Port, Mumbai",
                                                 "remark": "Vessel arrived safely and is awaiting berth allocation.",
                                                 "shipRequirements": "Garbage disposal and oily waste reception facilities required.",
                                                 "masterContact": {
                                                   "name": "Captain John Doe",
                                                   "email": "captain.john@oceanvoyager.com",
                                                   "phone": "+91-9876543210"
                                                 },
                                                 "agentContact": {
                                                   "name": "Jane Smith",
                                                   "email": "jane.smith@globalshipping.in",
                                                   "phone": "+91-9123456789"
                                                 },
                                                 "certificateOfRegistry": {
                                                   "name": "Certificate of Registry",
                                                   "date": "2023-10-20",
                                                   "port": "Mumbai"
                                                 },
                                                 "dateAndTimeOfArrival": {
                                                   "actual": "2024-02-29T10:30:00+05:30",
                                                   "estimated": "2024-02-29T10:00:00+05:30"
                                                 },
                                                 "dateAndTimeOfDeparture": {
                                                   "actual": "2024-02-29T18:45:00+05:30",
                                                   "estimated": "2024-02-29T18:30:00+05:30"
                                                 },
                                                 "attachedDocuments": [
                                                   "Cargo Declaration",
                                                   "Ship's Stores Declaration",
                                                   "Crew List",
                                                   "Passenger List",
                                                   "Crew's Effects Declaration",
                                                   "Maritime Declaration of Health"
                                                 ],
                                                 "voyagePortCalls": [
                                                   {
                                                     "portName": "Port of Singapore",
                                                     "country": "Singapore",
                                                     "arrivalDate": "2024-02-15",
                                                     "departureDate": "2024-02-15",
                                                     "load": "yes",
                                                     "discharge": "yes"
                                                   },
                                                   {
                                                     "portName": "Port Klang",
                                                     "country": "Malaysia",
                                                     "arrivalDate": "2024-02-18",
                                                     "departureDate": "2024-02-18",
                                                     "load": "yes",
                                                     "discharge": "no"
                                                   },
                                                   {
                                                     "portName": "Colombo Port",
                                                     "country": "Sri Lanka",
                                                     "arrivalDate": "2024-02-22",
                                                     "departureDate": "2024-02-22",
                                                     "load": "no",
                                                     "discharge": "yes"
                                                   },
                                                   {
                                                     "portName": "Jawaharlal Nehru Port, Mumbai",
                                                     "country": "India",
                                                     "arrivalDate": "2024-02-29",
                                                     "departureDate": "2024-02-29",
                                                     "load": "no",
                                                     "discharge": "yes"
                                                   },
                                                   {
                                                     "portName": "Mundra Port",
                                                     "country": "India",
                                                     "arrivalDate": "2024-03-02",
                                                     "departureDate": "2024-03-02",
                                                     "load": "yes",
                                                     "discharge": "no"
                                                   },
                                                   {
                                                     "portName": "Jebel Ali Port",
                                                     "country": "United Arab Emirates",
                                                     "arrivalDate": "2024-03-06",
                                                     "departureDate": "2024-03-06",
                                                     "load": "yes",
                                                     "discharge": "yes"
                                                   },
                                                   {
                                                     "portName": "Port of Salalah",
                                                     "country": "Oman",
                                                     "arrivalDate": "2024-03-10",
                                                     "departureDate": "2024-03-10",
                                                     "load": "no",
                                                     "discharge": "yes"
                                                   }
                                                 ]
                                               }
                                             }
                                             
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomPdfResponseTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))
                    )
            }
    )
    public ResponseEntity<?> createGeneralDeclaration(@RequestBody @Valid GeneralDeclarationTO generalDeclarationTO) {
        return imoFalDocumentsService.createGeneralDeclaration(generalDeclarationTO);
    }

    //    CARGO DECLARATION
    @PostMapping("/cargo-declaration")
    @Operation(
            summary = "Cargo Declaration",
            description = """
                    This endpoint is used to generate the IMO Cargo Declaration document.
                                        
                     All the fields are **mandatory** while generating the pdf.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Cargo Declaration",
                                    value = """
                                            {
                                              "docType": {
                                                "arrival": true,
                                                "departure": false
                                              },
                                              "authenticationInformation": {
                                                "date": "2024-02-29",
                                                "signature": "Captain John Doe"
                                              },
                                              "voyageInformation": {
                                                "nameOfShip": "Ocean Voyager",
                                                "imoNumber": "IMO9876543",
                                                "callSign": "VTAB",
                                                "voyageNumber": "OV-IND-0224",
                                                "flagState": "India",
                                                "portOfReport": "Jawaharlal Nehru Port, Mumbai",
                                                "portOfDischarge": "Chennai Port",
                                                "portOfLoading": "Port of Singapore",
                                                "masterContact": {
                                                  "name": "Captain John Doe",
                                                  "email": "captain.john@oceanvoyager.com",
                                                  "phone": "+91-9876543210"
                                                }
                                              },
                                              "cargoItems": [
                                                {
                                                  "blNumber": "BL-001",
                                                  "marksAndNumbers": "CONT-IND-001",
                                                  "description": "Electrical machinery and equipment",
                                                  "hsCode": "850440",
                                                  "grossWeight": "980 kg",
                                                  "measurement": "9.8 cubic meters"
                                                },
                                                {
                                                  "blNumber": "BL-002",
                                                  "marksAndNumbers": "CONT-IND-002",
                                                  "description": "Plastic articles for industrial use",
                                                  "hsCode": "392690",
                                                  "grossWeight": "850 kg",
                                                  "measurement": "8.5 cubic meters"
                                                },
                                                {
                                                  "blNumber": "BL-003",
                                                  "marksAndNumbers": "CONT-IND-003",
                                                  "description": "Iron and steel fasteners",
                                                  "hsCode": "731815",
                                                  "grossWeight": "1200 kg",
                                                  "measurement": "11.5 cubic meters"
                                                },
                                                {
                                                  "blNumber": "BL-004",
                                                  "marksAndNumbers": "CONT-IND-004",
                                                  "description": "Printed circuit boards",
                                                  "hsCode": "853400",
                                                  "grossWeight": "720 kg",
                                                  "measurement": "7.2 cubic meters"
                                                },
                                                {
                                                  "blNumber": "BL-005",
                                                  "marksAndNumbers": "CONT-IND-005",
                                                  "description": "Household electrical appliances",
                                                  "hsCode": "851679",
                                                  "grossWeight": "1050 kg",
                                                  "measurement": "10.2 cubic meters"
                                                }
                                              ]
                                            }                                                                                       
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomPdfResponseTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))
                    )
            }
    )
    public ResponseEntity<?> createCargoDeclaration(@RequestBody @Valid CargoDeclarationTO cargoDeclarationTO) {
        return imoFalDocumentsService.createCargoDeclaration(cargoDeclarationTO);
    }

    //    SHIP STORES DECLARATION
    @PostMapping("/ships-store")
    @Operation(
            summary = "Ship Stores",
            description = """
                    This endpoint is used to generate the IMO Ship Stores document.
                                        
                     All the fields are **mandatory** while generating the pdf.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Ships Stores",
                                    value = """
                                            {
                                                "authenticationInformation": {
                                                  "date": "2024-02-29",
                                                  "signature": "Captain John Doe"
                                                },
                                                "docType": {
                                                  "arrival": true,
                                                  "departure": false
                                                },
                                                "voyageInformation": {
                                                  "nameOfShip": "Ocean Voyager",
                                                  "imoNumber": "IMO9876543",
                                                  "callSign": "VTAB",
                                                  "voyageNumber": "OV-IND-0224",
                                                  "flagState": "India",
                                                  "currentPort": "Jawaharlal Nehru Port, Mumbai",
                                                  "numberOfPersonsOnBoard": 120,
                                                  "periodOfStay": "7 Days",
                                                  "masterContact": {
                                                    "name": "Captain John Doe",
                                                    "email": "captain.john@oceanvoyager.com",
                                                    "phone": "+91-9876543210"
                                                  },
                                                  "dateAndTimeOfArrival": {
                                                    "actual": "2024-02-29T10:30:00+05:30",
                                                    "estimated": "2024-02-29T10:00:00+05:30"
                                                  },
                                                  "dateAndTimeOfDeparture": {
                                                    "actual": "2024-03-07T18:00:00+05:30",
                                                    "estimated": "2024-03-07T17:30:00+05:30"
                                                  },
                                                  "voyagePortCalls": [
                                                    {
                                                      "portName": "Port of Singapore",
                                                      "country": "Singapore",
                                                      "arrivalDate": "2024-02-15",
                                                      "departureDate": "2024-02-15",
                                                      "load": "yes",
                                                      "discharge": "yes"
                                                    },
                                                    {
                                                      "portName": "Colombo Port",
                                                      "country": "Sri Lanka",
                                                      "arrivalDate": "2024-02-20",
                                                      "departureDate": "2024-02-20",
                                                      "load": "no",
                                                      "discharge": "yes"
                                                    },
                                                    {
                                                      "portName": "Jawaharlal Nehru Port, Mumbai",
                                                      "country": "India",
                                                      "arrivalDate": "2024-02-29",
                                                      "departureDate": "2024-03-07",
                                                      "load": "no",
                                                      "discharge": "yes"
                                                    },
                                                    {
                                                      "portName": "Mundra Port",
                                                      "country": "India",
                                                      "arrivalDate": "2024-03-10",
                                                      "departureDate": "2024-03-10",
                                                      "load": "yes",
                                                      "discharge": "no"
                                                    }
                                                  ]
                                                },
                                                "storesItems": [
                                                  {
                                                    "nameOfArticle": "Food Provisions",
                                                    "quantity": 180,
                                                    "locationOnBoard": "Galley",
                                                    "officialUse": "Crew consumption"
                                                  },
                                                  {
                                                    "nameOfArticle": "Medical Supplies",
                                                    "quantity": 25,
                                                    "locationOnBoard": "Medical Bay",
                                                    "officialUse": "Emergency and routine care"
                                                  },
                                                  {
                                                    "nameOfArticle": "Navigation Charts and Publications",
                                                    "quantity": 12,
                                                    "locationOnBoard": "Bridge",
                                                    "officialUse": "Safe navigation"
                                                  },
                                                  {
                                                    "nameOfArticle": "Safety Equipment",
                                                    "quantity": 45,
                                                    "locationOnBoard": "Safety Locker",
                                                    "officialUse": "Emergency preparedness"
                                                  },
                                                  {
                                                    "nameOfArticle": "Engine Spare Parts",
                                                    "quantity": 35,
                                                    "locationOnBoard": "Engine Room Store",
                                                    "officialUse": "Maintenance and repairs"
                                                  }
                                                ]
                                              }
                                                    
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomPdfResponseTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))
                    )
            }
    )
    public ResponseEntity<?> createShipsStoresDeclaration(@RequestBody @Valid ShipsStoreDeclarationTO shipsStoreDeclarationTO) {
        return imoFalDocumentsService.createShipsStoreDeclaration(shipsStoreDeclarationTO);
    }

    //    CREW EFFECTS DECLARATION
    @PostMapping("/crews-effects")
    @Operation(
            summary = "Crew Effects",
            description = """
                    This endpoint is used to generate the IMO Crew Effects document.
                                       
                    All the fields are **mandatory** while generating the pdf.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Crew Effects",
                                    value = """
                                            {
                                              "docType": {
                                                "arrival": true,
                                                "departure": false
                                              },
                                              "voyageInformation": {
                                                "nameOfShip": "Ocean Voyager",
                                                "imoNumber": "IMO9876543",
                                                "callSign": "VTAB",
                                                "voyageNumber": "OV-IND-0224",
                                                "flagState": "India"
                                              },
                                              "crewDetails": [
                                                {
                                                  "familyName": "Sharma",
                                                  "givenNames": "Rakesh",
                                                  "rankOrRating": "Master",
                                                  "effectsIneligible": "No",
                                                  "signature": "Rakesh Sharma"
                                                },
                                                {
                                                  "familyName": "Fernandes",
                                                  "givenNames": "Anthony",
                                                  "rankOrRating": "Chief Officer",
                                                  "effectsIneligible": "No",
                                                  "signature": "Anthony Fernandes"
                                                },
                                                {
                                                  "familyName": "Patel",
                                                  "givenNames": "Amit",
                                                  "rankOrRating": "Second Officer",
                                                  "effectsIneligible": "No",
                                                  "signature": "Amit Patel"
                                                },
                                                {
                                                  "familyName": "Iyer",
                                                  "givenNames": "Suresh",
                                                  "rankOrRating": "Chief Engineer",
                                                  "effectsIneligible": "No",
                                                  "signature": "Suresh Iyer"
                                                },
                                                {
                                                  "familyName": "Singh",
                                                  "givenNames": "Vikram",
                                                  "rankOrRating": "Second Engineer",
                                                  "effectsIneligible": "Yes",
                                                  "signature": "Vikram Singh"
                                                },
                                                {
                                                  "familyName": "Nair",
                                                  "givenNames": "Rahul",
                                                  "rankOrRating": "Third Engineer",
                                                  "effectsIneligible": "No",
                                                  "signature": "Rahul Nair"
                                                },
                                                {
                                                  "familyName": "Khan",
                                                  "givenNames": "Imran",
                                                  "rankOrRating": "Bosun",
                                                  "effectsIneligible": "Yes",
                                                  "signature": "Imran Khan"
                                                },
                                                {
                                                  "familyName": "Das",
                                                  "givenNames": "Anil",
                                                  "rankOrRating": "Able Seaman",
                                                  "effectsIneligible": "No",
                                                  "signature": "Anil Das"
                                                }
                                              ],
                                              "authenticationInformation": {
                                                "date": "2024-02-29",
                                                "signature": "Rakesh Sharma"
                                              }
                                            }                                                                                   
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomPdfResponseTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))
                    )
            }
    )
    public ResponseEntity<?> createCrewsEffectsDeclaration(@RequestBody @Valid CrewsEffectsDeclarationTO crewsEffectsDeclarationTO) {
        return imoFalDocumentsService.createCrewsEffectsDeclaration(crewsEffectsDeclarationTO);
    }

    //    CREW LIST
    @PostMapping("/crew-list")
    @Operation(
            summary = "Crew List",
            description = """
                    This endpoint is used to generate the IMO Crew List document.
                                        
                     All the fields are **mandatory** while generating the pdf.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Crew List",
                                    value = """
                                            {
                                              "docType": {
                                                "arrival": true,
                                                "departure": false
                                              },
                                              "authenticationInformation": {
                                                "date": "2024-02-29",
                                                "signature": "Captain John Doe"
                                              },
                                              "voyageInformation": {
                                                "nameOfShip": "Ocean Voyager",
                                                "imoNumber": "IMO9876543",
                                                "callSign": "VTAB",
                                                "voyageNumber": "OV-IND-0224",
                                                "flagState": "India",
                                                "currentPort": "Jawaharlal Nehru Port, Mumbai",
                                                "numberOfPersonsOnBoard": 120,
                                                "periodOfStay": "7 Days",
                                                "dateAndTimeOfArrival": {
                                                  "actual": "2024-02-29T18:45:00+05:30",
                                                  "estimated": "2024-02-29T18:30:00+05:30"
                                                },
                                                "dateAndTimeOfDeparture": {
                                                  "actual": "2024-03-07T18:00:00+05:30",
                                                  "estimated": "2024-03-07T17:45:00+05:30"
                                                },
                                                "voyagePortCalls": [
                                                  {
                                                    "portName": "Port of Singapore",
                                                    "country": "Singapore",
                                                    "arrivalDate": "2024-02-15",
                                                    "departureDate": "2024-02-15",
                                                    "load": "yes",
                                                    "discharge": "yes"
                                                  },
                                                  {
                                                    "portName": "Colombo Port",
                                                    "country": "Sri Lanka",
                                                    "arrivalDate": "2024-02-20",
                                                    "departureDate": "2024-02-20",
                                                    "load": "no",
                                                    "discharge": "yes"
                                                  },
                                                  {
                                                    "portName": "Jawaharlal Nehru Port, Mumbai",
                                                    "country": "India",
                                                    "arrivalDate": "2024-02-29",
                                                    "departureDate": "2024-03-07",
                                                    "load": "no",
                                                    "discharge": "yes"
                                                  },
                                                  {
                                                    "portName": "Mundra Port",
                                                    "country": "India",
                                                    "arrivalDate": "2024-03-10",
                                                    "departureDate": "2024-03-10",
                                                    "load": "yes",
                                                    "discharge": "no"
                                                  }
                                                ]
                                              },
                                              "crewMembers": [
                                                {
                                                  "familyName": "Sharma",
                                                  "givenNames": "Rakesh",
                                                  "rankOrRating": "Master",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1980-05-15",
                                                  "placeOfBirth": "Mumbai",
                                                  "gender": "Male",
                                                  "natureOfIdentityDocument": "Passport",
                                                  "identityDocumentNumber": "IN1234567",
                                                  "issuingStateOfIdentityDocument": "India",
                                                  "expiryDateOfIdentityDocument": "2026-05-15"
                                                },
                                                {
                                                  "familyName": "Fernandes",
                                                  "givenNames": "Anthony",
                                                  "rankOrRating": "Chief Officer",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1985-08-20",
                                                  "placeOfBirth": "Goa",
                                                  "gender": "Male",
                                                  "natureOfIdentityDocument": "Seaman's book",
                                                  "identityDocumentNumber": "IN7654321",
                                                  "issuingStateOfIdentityDocument": "India",
                                                  "expiryDateOfIdentityDocument": "2025-08-20"
                                                },
                                                {
                                                  "familyName": "Patel",
                                                  "givenNames": "Amit",
                                                  "rankOrRating": "Second Officer",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1990-03-10",
                                                  "placeOfBirth": "Ahmedabad",
                                                  "gender": "Male",
                                                  "natureOfIdentityDocument": "Seaman's book",
                                                  "identityDocumentNumber": "IN2345678",
                                                  "issuingStateOfIdentityDocument": "India",
                                                  "expiryDateOfIdentityDocument": "2027-03-10"
                                                },
                                                {
                                                  "familyName": "Iyer",
                                                  "givenNames": "Suresh",
                                                  "rankOrRating": "Chief Engineer",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1988-11-25",
                                                  "placeOfBirth": "Chennai",
                                                  "gender": "Male",
                                                  "natureOfIdentityDocument": "Passport",
                                                  "identityDocumentNumber": "IN8765432",
                                                  "issuingStateOfIdentityDocument": "India",
                                                  "expiryDateOfIdentityDocument": "2026-11-25"
                                                },
                                                {
                                                  "familyName": "Singh",
                                                  "givenNames": "Vikram",
                                                  "rankOrRating": "Second Engineer",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1992-04-18",
                                                  "placeOfBirth": "Delhi",
                                                  "gender": "Male",
                                                  "natureOfIdentityDocument": "Seaman's book",
                                                  "identityDocumentNumber": "IN3456789",
                                                  "issuingStateOfIdentityDocument": "India",
                                                  "expiryDateOfIdentityDocument": "2028-04-18"
                                                },
                                                {
                                                  "familyName": "Nair",
                                                  "givenNames": "Rahul",
                                                  "rankOrRating": "Third Engineer",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1983-07-12",
                                                  "placeOfBirth": "Kochi",
                                                  "gender": "Male",
                                                  "natureOfIdentityDocument": "Seaman's book",
                                                  "identityDocumentNumber": "IN4567890",
                                                  "issuingStateOfIdentityDocument": "India",
                                                  "expiryDateOfIdentityDocument": "2029-07-12"
                                                },
                                                {
                                                  "familyName": "Das",
                                                  "givenNames": "Anil",
                                                  "rankOrRating": "Bosun",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1995-09-08",
                                                  "placeOfBirth": "Kolkata",
                                                  "gender": "Male",
                                                  "natureOfIdentityDocument": "Passport",
                                                  "identityDocumentNumber": "IN5678901",
                                                  "issuingStateOfIdentityDocument": "India",
                                                  "expiryDateOfIdentityDocument": "2027-09-08"
                                                },
                                                {
                                                  "familyName": "Kaur",
                                                  "givenNames": "Simran",
                                                  "rankOrRating": "Steward",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1986-12-30",
                                                  "placeOfBirth": "Amritsar",
                                                  "gender": "Female",
                                                  "natureOfIdentityDocument": "Passport",
                                                  "identityDocumentNumber": "IN6789012",
                                                  "issuingStateOfIdentityDocument": "India",
                                                  "expiryDateOfIdentityDocument": "2027-12-30"
                                                }
                                              ]
                                            }
                                                  
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomPdfResponseTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))
                    )
            }
    )
    public ResponseEntity<?> createCrewList(@RequestBody @Valid CrewListTO crewListTO) {
        return imoFalDocumentsService.createCrewList(crewListTO);
    }

    //    PASSENGER LIST
    @PostMapping("/passenger-list")
    @Operation(
            summary = "Passenger List",
            description = """
                    This endpoint is used to generate the IMO Passenger List document.
                                        
                     All the fields are **mandatory** while generating the pdf.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Passenger List",
                                    value = """
                                            {
                                              "docType": {
                                                "arrival": true,
                                                "departure": false
                                              },
                                              "authenticationInformation": {
                                                "date": "2024-02-29",
                                                "signature": "Captain John Doe"
                                              },
                                              "voyageInformation": {
                                                "nameOfShip": "Ocean Voyager",
                                                "imoNumber": "IMO9876543",
                                                "callSign": "VTAB",
                                                "voyageNumber": "OV-IND-0224",
                                                "flagState": "India",
                                                "currentPort": "Jawaharlal Nehru Port, Mumbai",
                                                "masterContact": {
                                                  "name": "Captain John Doe",
                                                  "email": "captain.john@example.com",
                                                  "phone": "+91 22 1234 5678"
                                                },
                                                "dateAndTimeOfArrival": {
                                                  "actual": "2024-02-29T18:45:00+05:30",
                                                  "estimated": "2024-02-29T18:30:00+05:30"
                                                },
                                                "dateAndTimeOfDeparture": {
                                                  "actual": "2024-03-07T18:00:00+05:30",
                                                  "estimated": "2024-03-07T17:45:00+05:30"
                                                },
                                                "voyagePortCalls": [
                                                  {
                                                    "portName": "Port of Singapore",
                                                    "country": "Singapore",
                                                    "arrivalDate": "2024-02-15",
                                                    "departureDate": "2024-02-15",
                                                    "load": "yes",
                                                    "discharge": "yes"
                                                  },
                                                  {
                                                    "portName": "Colombo Port",
                                                    "country": "Sri Lanka",
                                                    "arrivalDate": "2024-02-20",
                                                    "departureDate": "2024-02-20",
                                                    "load": "no",
                                                    "discharge": "yes"
                                                  },
                                                  {
                                                    "portName": "Jawaharlal Nehru Port, Mumbai",
                                                    "country": "India",
                                                    "arrivalDate": "2024-02-29",
                                                    "departureDate": "2024-03-07",
                                                    "load": "no",
                                                    "discharge": "yes"
                                                  },
                                                  {
                                                    "portName": "Mundra Port",
                                                    "country": "India",
                                                    "arrivalDate": "2024-03-10",
                                                    "departureDate": "2024-03-10",
                                                    "load": "yes",
                                                    "discharge": "no"
                                                  }
                                                ]
                                              },
                                              "passengers": [
                                                {
                                                  "familyName": "Smith",
                                                  "givenNames": "John",
                                                  "nationality": "USA",
                                                  "dateOfBirth": "1990-05-15",
                                                  "placeOfBirth": "New York",
                                                  "gender": "Male",
                                                  "typeOfIdentity": "Passport",
                                                  "serialNumberOfIdentity": "USA123456",
                                                  "issuingStateOfIdentity": "USA",
                                                  "expiryDateOfIdentity": "2026-05-15",
                                                  "embarkationPort": "Port of Los Angeles, USA",
                                                  "disembarkationPort": "Port of Singapore, Singapore",
                                                  "visaNumber": "USAB1234",
                                                  "transitPassenger": true
                                                },
                                                {
                                                  "familyName": "Garcia",
                                                  "givenNames": "Maria",
                                                  "nationality": "Spain",
                                                  "dateOfBirth": "1985-10-20",
                                                  "placeOfBirth": "Madrid",
                                                  "gender": "Female",
                                                  "typeOfIdentity": "Passport",
                                                  "serialNumberOfIdentity": "ESP987654",
                                                  "issuingStateOfIdentity": "Spain",
                                                  "expiryDateOfIdentity": "2025-10-20",
                                                  "embarkationPort": "Port of Barcelona, Spain",
                                                  "disembarkationPort": "Port of Valencia, Spain",
                                                  "visaNumber": "ESP5678",
                                                  "transitPassenger": false
                                                },
                                                {
                                                  "familyName": "Kim",
                                                  "givenNames": "Soo Min",
                                                  "nationality": "South Korea",
                                                  "dateOfBirth": "1988-03-10",
                                                  "placeOfBirth": "Seoul",
                                                  "gender": "Female",
                                                  "typeOfIdentity": "Passport",
                                                  "serialNumberOfIdentity": "KOR456789",
                                                  "issuingStateOfIdentity": "South Korea",
                                                  "expiryDateOfIdentity": "2027-03-10",
                                                  "embarkationPort": "Busan Port, South Korea",
                                                  "disembarkationPort": "Port of Singapore, Singapore",
                                                  "visaNumber": "KOR9012",
                                                  "transitPassenger": false
                                                },
                                                {
                                                  "familyName": "Singh",
                                                  "givenNames": "Rajesh",
                                                  "nationality": "India",
                                                  "dateOfBirth": "1982-08-25",
                                                  "placeOfBirth": "Mumbai",
                                                  "gender": "Male",
                                                  "typeOfIdentity": "Passport",
                                                  "serialNumberOfIdentity": "IND654321",
                                                  "issuingStateOfIdentity": "India",
                                                  "expiryDateOfIdentity": "2029-08-25",
                                                  "embarkationPort": "Jawaharlal Nehru Port, India",
                                                  "disembarkationPort": "Mundra Port, India",
                                                  "visaNumber": "IND3456",
                                                  "transitPassenger": true
                                                }
                                              ]
                                            }
                                                  
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomPdfResponseTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))
                    )
            }
    )
    public ResponseEntity<?> createPassengerList(@RequestBody @Valid PassengerListTO passengerListTO) {
        return imoFalDocumentsService.createPassengerList(passengerListTO);
    }

    //    DANGEROUS GOODS MANIFEST
    @PostMapping("/dangerous-goods")
    @Operation(
            summary = "Dangerous Goods",
            description = """
                    This endpoint is used to generate the IMO Dangerous Goods document.
                                        
                     All the fields are **mandatory** while generating the pdf.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Dangerous Goods",
                                    value = """
                                            {
                                              "docType": {
                                                "arrival": true,
                                                "departure": false
                                              },
                                              "voyageInformation": {
                                                "nameOfShip": "Ocean Voyager",
                                                "imoNumber": "IMO9876543",
                                                "callSign": "VTAB",
                                                "voyageNumber": "OV-IND-0224",
                                                "flagState": "India",
                                                "currentPort": "Jawaharlal Nehru Port, Mumbai",
                                                "numberOfPersonsOnBoard": 120,
                                                "periodOfStay": "7 Days",
                                                "portOfLoading": "Port of Singapore, Singapore",
                                                "portOfDischarge": "Jawaharlal Nehru Port, India",
                                                "stowagePosition": "Deck A",
                                                "referenceNumber": "REF123"
                                              },
                                              "dangerousGoods": [
                                                {
                                                  "marksAndNumbers": "ABC123",
                                                  "freightContainerIdentification": "SGP001",
                                                  "vehicleRegistrationNumbers": "SG-CAR001",
                                                  "unNumber": "1203",
                                                  "properShippingName": "Gasoline",
                                                  "class": "Class 3",
                                                  "packingGroup": "PG II",
                                                  "additionalInformation": "Flash Point: 30°C",
                                                  "numberOfPackages": "10",
                                                  "massOrVolume": "500 kg",
                                                  "ems": "F-E"
                                                },
                                                {
                                                  "marksAndNumbers": "XYZ789",
                                                  "freightContainerIdentification": "CMB002",
                                                  "vehicleRegistrationNumbers": "CMB-TRK001",
                                                  "unNumber": "1760",
                                                  "properShippingName": "Corrosive Liquid, N.O.S.",
                                                  "class": "Class 8",
                                                  "packingGroup": "PG III",
                                                  "additionalInformation": "Marine Pollutant",
                                                  "numberOfPackages": "5",
                                                  "massOrVolume": "200 L",
                                                  "ems": "S-C"
                                                },
                                                {
                                                  "marksAndNumbers": "DEF456",
                                                  "freightContainerIdentification": "MUM003",
                                                  "vehicleRegistrationNumbers": "MUM-VAN001",
                                                  "unNumber": "1070",
                                                  "properShippingName": "Chlorine, Compressed Gas",
                                                  "class": "Class 2.3",
                                                  "packingGroup": "PG I",
                                                  "additionalInformation": "Poison Gas",
                                                  "numberOfPackages": "3",
                                                  "massOrVolume": "50 kg",
                                                  "ems": "T-G"
                                                },
                                                {
                                                  "marksAndNumbers": "GHI789",
                                                  "freightContainerIdentification": "ROT004",
                                                  "vehicleRegistrationNumbers": "NL-TRL001",
                                                  "unNumber": "0333",
                                                  "properShippingName": "Explosive, Detonator",
                                                  "class": "Class 1.4",
                                                  "packingGroup": "PG II",
                                                  "additionalInformation": "Detonators",
                                                  "numberOfPackages": "15",
                                                  "massOrVolume": "1000 kg",
                                                  "ems": "E-EXP"
                                                },
                                                {
                                                  "marksAndNumbers": "JKL012",
                                                  "freightContainerIdentification": "HAM005",
                                                  "vehicleRegistrationNumbers": "DE-TRK002",
                                                  "unNumber": "1325",
                                                  "properShippingName": "Cellulose Nitrate, Solid",
                                                  "class": "Class 4.1",
                                                  "packingGroup": "PG III",
                                                  "additionalInformation": "Self-reactive",
                                                  "numberOfPackages": "8",
                                                  "massOrVolume": "300 kg",
                                                  "ems": "S-SR"
                                                },
                                                {
                                                  "marksAndNumbers": "MNO345",
                                                  "freightContainerIdentification": "LON006",
                                                  "vehicleRegistrationNumbers": "UK-CAR002",
                                                  "unNumber": "1479",
                                                  "properShippingName": "Organic Peroxide Type D",
                                                  "class": "Class 5.1",
                                                  "packingGroup": "PG II",
                                                  "additionalInformation": "Oxidizing Agent",
                                                  "numberOfPackages": "7",
                                                  "massOrVolume": "400 L",
                                                  "ems": "O-D"
                                                },
                                                {
                                                  "marksAndNumbers": "PQR678",
                                                  "freightContainerIdentification": "NY007",
                                                  "vehicleRegistrationNumbers": "US-TRL002",
                                                  "unNumber": "2910",
                                                  "properShippingName": "Radioactive Material, Type A",
                                                  "class": "Class 7",
                                                  "packingGroup": "N/A",
                                                  "additionalInformation": "Gamma Radiation",
                                                  "numberOfPackages": "1",
                                                  "massOrVolume": "10 kg",
                                                  "ems": "R-A"
                                                },
                                                {
                                                  "marksAndNumbers": "STU901",
                                                  "freightContainerIdentification": "SYD008",
                                                  "vehicleRegistrationNumbers": "AU-TRK003",
                                                  "unNumber": "3077",
                                                  "properShippingName": "Environmentally Hazardous Substance, Solid, N.O.S.",
                                                  "class": "Class 9",
                                                  "packingGroup": "N/A",
                                                  "additionalInformation": "Marine Pollutant",
                                                  "numberOfPackages": "12",
                                                  "massOrVolume": "600 kg",
                                                  "ems": "M-H"
                                                }
                                              ],
                                              "shippingAgentDetails": {
                                                "name": "John Doe",
                                                "place": "Jawaharlal Nehru Port, Mumbai",
                                                "date": "2024-02-15",
                                                "signature": "John Doe"
                                              }
                                            }
                                                   
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomPdfResponseTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))
                    )
            }
    )
    public ResponseEntity<?> createDangerousGoodsManifest(@RequestBody @Valid DangerousGoodsManifestTO dangerousGoodsManifestTO) {
        return imoFalDocumentsService.createDangerousGoodsManifest(dangerousGoodsManifestTO);
    }

    //    SHIP PARTICULARS
    @PostMapping("/ships-particulars")
    @Operation(
            summary = "Ships Particulars",
            description = """
                    This endpoint is used to generate the Custom Ships Particulars document.
                                        
                     All the fields are **mandatory** while generating the pdf.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Ships Particulars",
                                    value = """
                                            {
                                                "callSign": "VROR5",
                                                "flag": "HONG KONG",
                                                "portOfRegistry": "HONG KONG",
                                                "officialNumber": "HK-4373",
                                                "imoLloydsNumber": "9707637",
                                                "classSociety": "NK",
                                                "piClub": "GARD",
                                                "classNotationsLine1": "NS*(CSR, BC-A, BC-XII, GRAB 20, PSPC-WBT)",
                                                "classNotationsLine2": "(ESP)(IWS)(PSCM)(BWTS)(IHM)MNS*(M0)",
                                                "shipsParticulars": {
                                                    "type": "M/V",
                                                    "name": "Trident Star",
                                                    "deadweightTonnage": 57836,
                                                    "vesselType": "Bulk Carrier",
                                                    "keelLaid": "2015-01-12",
                                                    "launched": "2015-01-12",
                                                    "delivered": "2015-01-12",
                                                    "shipYardLine1": "TSUNEISHI HEAVY INDUSTRIES (CEBU), INC.",
                                                    "principalDimensions": {
                                                        "loa": "189.99 M",
                                                        "lbp": "185.78 M",
                                                        "breadth": "32.26 M",
                                                        "depth": "18.00 M",
                                                        "heightMax": "47.516 M",
                                                        "bridgeFrontToBow": "162.72 M",
                                                        "bridgeFrontToStern": "27.27 M",
                                                        "lightShipDisplacement": "9974",
                                                        "regd": {
                                                            "netTonnage": "19449",
                                                            "grossTonnage": "32370",
                                                            "grossTonnageReduced": "5982"
                                                        },
                                                        "suez": {
                                                            "netTonnage": "32241",
                                                            "grossTonnage": "32694.28",
                                                            "grossTonnageReduced": "1527"
                                                        },
                                                        "panam": {
                                                            "netTonnage": "26841",
                                                            "grossTonnage": "32370"
                                                        }
                                                    },
                                                    "loadLineInformation": {
                                                        "freeBoard": {
                                                            "tropical": "4.281 m",
                                                            "summer": "4.500 m",
                                                            "winter": "4.719 m",
                                                            "tropicalLumbar": "4.032 m",
                                                            "summerLumbar": "4.256 m",
                                                            "winterLumbar": "4.555 m",
                                                            "normalBallast": "8.86",
                                                            "heavyBallast": "9.262 m"
                                                        },
                                                        "draft": {
                                                            "tropical": "10.759 m",
                                                            "summer": "10.540 m",
                                                            "winter": "10.321 m",
                                                            "tropicalLumbar": "11.008 m",
                                                            "summerLumbar": "10.784 m",
                                                            "winterLumbar": "10.485 m",
                                                            "normalBallast": "6.18",
                                                            "heavyBallast": "8.79 m"
                                                        },
                                                        "dwt": {
                                                            "tropical": "38.720 m",
                                                            "summer": "37.655 m",
                                                            "winter": "36.592 m",
                                                            "tropicalLumbar": "39.934 m",
                                                            "summerLumbar": "38.841 m",
                                                            "winterLumbar": "37.387 m",
                                                            "normalBallast": "15.46",
                                                            "heavyBallast": "34923 mt"
                                                        },
                                                        "fwa": "238 mm",
                                                        "tpcForSummerDraft": "49.1 mt"
                                                    },
                                                    "tankCapacities": {
                                                        "grain": [
                                                            {
                                                                "cargoHold": "CARGO HOLD 1",
                                                                "value": 12704.5
                                                            },
                                                            {
                                                                "cargoHold": "CARGO HOLD 2",
                                                                "value": 15524.3
                                                            },
                                                            {
                                                                "cargoHold": "CARGO HOLD 3",
                                                                "value": 15231.8
                                                            },
                                                            {
                                                                "cargoHold": "CARGO HOLD 4",
                                                                "value": 15190.6
                                                            }
                                                        ],
                                                        "bale": [
                                                            {
                                                                "cargoHold": "CARGO HOLD 1",
                                                                "value": 12024.2
                                                            },
                                                            {
                                                                "cargoHold": "CARGO HOLD 2",
                                                                "value": 14810.9
                                                            },
                                                            {
                                                                "cargoHold": "CARGO HOLD 3",
                                                                "value": 14523.4
                                                            }
                                                        ],
                                                        "grainTotal": 72654.2,
                                                        "baleTotal": 69348
                                                    },
                                                    "ballastTank": {
                                                        "fpt": 1683.4,
                                                        "dbtList": [
                                                            {
                                                                "name": "DBT 1 P/S",
                                                                "dbtp": 1314.8,
                                                                "dbts": 1314.8
                                                            },
                                                            {
                                                                "name": "DBT 2 P/S",
                                                                "dbtp": 1314.8,
                                                                "dbts": 1314.8
                                                            },
                                                            {
                                                                "name": "DBT 3 P/S",
                                                                "dbtp": 1314.8,
                                                                "dbts": 1314.8
                                                            },
                                                            {
                                                                "name": "DBT 4 P/S",
                                                                "dbtp": 1314.8,
                                                                "dbts": 1314.8
                                                            },
                                                            {
                                                                "name": "DBT 5 P/S",
                                                                "dbtp": 1314.8,
                                                                "dbts": 1314.8
                                                            }
                                                        ],
                                                        "swbtList": [
                                                            {
                                                                "name": "SWT 1 P/S",
                                                                "swbtp": 1314.8,
                                                                "swbts": 1314.8
                                                            },
                                                            {
                                                                "name": "SWT 2 P/S",
                                                                "swbtp": 1314.8,
                                                                "swbts": 1314.8
                                                            },
                                                            {
                                                                "name": "SWT 3 P/S",
                                                                "swbtp": 1314.8,
                                                                "swbts": 1314.8
                                                            },
                                                            {
                                                                "name": "SWT 4 P/S",
                                                                "swbtp": 1314.8,
                                                                "swbts": 1314.8
                                                            },
                                                            {
                                                                "name": "SWT 5 P/S",
                                                                "swbtp": 1314.8,
                                                                "swbts": 1314.8
                                                            }
                                                        ],
                                                        "apt": 661,
                                                        "ch3": 15343.10,
                                                        "bTotal": 31553.90
                                                    },
                                                    "lumbarOrLogCapacity": {
                                                        "deck": [
                                                            4438,
                                                            5766.2,
                                                            5766.2,
                                                            5694.5,
                                                            4916.4
                                                        ],
                                                        "hold": [
                                                            7380.1,
                                                            9575.7,
                                                            9578.5,
                                                            9577.9,
                                                            9126.2
                                                        ],
                                                        "deckTotal": "26581.9",
                                                        "holdTotal": "45238"
                                                    },
                                                    "deckStanchionHeight": [
                                                        9.5,
                                                        11.5
                                                    ],
                                                    "machineryOrPropellerOrRudder": {
                                                        "mainEngine": "MITSUI MAN B&W 6S50ME-C8.2",
                                                        "mcr": "8200 kW x 108 rpm",
                                                        "ncr": "6970 kW x 102 rpm",
                                                        "maxCriticalRange": "55~66 RPM",
                                                        "auxBoiler": "OSAKA BOILER VERTICAL COMPOSITE",
                                                        "generator": "20 kW x 450 V x 60 Hz",
                                                        "emer": "80 kW x 450 V x 60 Hz",
                                                        "propeller": "Right hand of solid 4 bladed keyless AEROFOIL",
                                                        "rudder": "INGOT FORGED (NK) - Area Ratio: 1/60 1 Balancing Ratio: 0.270",
                                                        "steeringGear": "Electro-Hydraulic Driven, Rapson-Slid",
                                                        "fwGeneratorCap": "Tubular Type, KM15, Cap 15t/day"
                                                    },
                                                    "hfoTanks": [
                                                        {
                                                            "name": "NO.1 P",
                                                            "value": "364.7"
                                                        },
                                                        {
                                                            "name": "NO.1 P/S",
                                                            "value": "395.5/395.5"
                                                        },
                                                        {
                                                            "name": "NO.1 P/S",
                                                            "value": "435.5/174.4"
                                                        },
                                                        {
                                                            "name": "SETT/SERV",
                                                            "value": "56"
                                                        }
                                                    ],
                                                    "hfoTotal": 1821.6,
                                                    "mdoTanks": [
                                                        {
                                                            "name": "NO.1 S",
                                                            "value": "364.5"
                                                        },
                                                        {
                                                            "name": "NO.1/2 DO S",
                                                            "value": "87.5/53.2"
                                                        },
                                                        {
                                                            "name": "SERV.",
                                                            "value": "23.8"
                                                        }
                                                    ],
                                                    "winchesOrwindlassOrRopesOrEmergencyTowing": {
                                                        "winches": {
                                                            "fwt": 1,
                                                            "aft": 1,
                                                            "particulars": "128 kN x 15 m/min x 2 sets"
                                                        },
                                                        "windclass": {
                                                            "fwt": 4,
                                                            "aft": 2,
                                                            "particulars": "128 kN x 15 m/min x 2 sets"
                                                        },
                                                        "anchor": {
                                                            "fwt": 2,
                                                            "aft": 3,
                                                            "particulars": "AC-14 Type, 6620 kg x 2 sets"
                                                        },
                                                        "emergencyTowing": {
                                                            "fwt": 1,
                                                            "aft": 2,
                                                            "particulars": "6620 kg x 2 sets"
                                                        }
                                                    },
                                                    "fwTank": [
                                                        {
                                                            "name": "FWP",
                                                            "value": 156
                                                        },
                                                        {
                                                            "name": "DFWTS",
                                                            "value": 156
                                                        }
                                                    ],
                                                    "fwTankTotal": 312,
                                                    "cargoAndBallastPumpingSystem": {
                                                        "ballast": {
                                                            "name": "BALLAST P/P",
                                                            "quantity": 2,
                                                            "capacity": "700 m3/h",
                                                            "head": "700 m3/h"
                                                        },
                                                        "fireGs": {
                                                            "name": "FIRE GS P/P",
                                                            "quantity": 1,
                                                            "capacity": "100/25 m3/h",
                                                            "head": "64/25 mTH"
                                                        },
                                                        "ballastEductor": {
                                                            "name": "BALLAST Eductor",
                                                            "quantity": 1,
                                                            "capacity": "100/25 m3/h",
                                                            "head": "64/25 mTH"
                                                        }
                                                    },
                                                    "deckCranes": "IHI Electro-Hydraulic Driven x 4 sets SWL 30 mt, 24 mt",
                                                    "distanceWLcoaming": {
                                                        "ballastCondition": {
                                                            "hatch": "16.03 m",
                                                            "midShips": "15.24 m",
                                                            "lastHatch": "14.44 m"
                                                        },
                                                        "fullBallastCondition": {
                                                            "hatch": "12.17 m",
                                                            "midShips": "11.57 m",
                                                            "lastHatch": "10.96 m"
                                                        },
                                                        "lightCondition": {
                                                            "hatch": "16.03 m",
                                                            "midShips": "15.24 m",
                                                            "lastHatch": "14.44 m"
                                                        },
                                                        "fullLadenCondition": {
                                                            "hatch": "17.68 m",
                                                            "midShips": "17.03 m",
                                                            "lastHatch": "16.92 m"
                                                        },
                                                        "distanceFromKeelToTopOfHatchCoaming": "123"
                                                    },
                                                    "lifeBoat": {
                                                        "noOfPerson": 25,
                                                        "size": "7.5 m * 2.75 m * 3.4 m"
                                                    },
                                                    "rescueBoat": {
                                                        "noOfPerson": 25,
                                                        "size": "4.5 m * 2.75 m * 3.4 m"
                                                    },
                                                    "lifeRafts": {
                                                        "size": "25 * 2,6 * 1"
                                                    },
                                                    "LRaftHandlingDavit": {
                                                        "name": "NORSAFE NDSC COMBI Davit SWL",
                                                        "size": "2.5 mt"
                                                    },
                                                    "minBowDrft": "2.5 kts",
                                                    "propellerImmer": "149 %",
                                                    "cementHoleDia": "700 mm",
                                                    "a60": "Fire doors, deck and bulkhead",
                                                    "hatchCoverSize": {
                                                        "h1": "18.2 m * 17 m",
                                                        "h2": "21.16 m * 18.6 m",
                                                        "h5": "20.16 m * 18.6 m"
                                                    },
                                                    "otherDetails": {
                                                        "detail": "End Folding Weather-tight Steel"
                                                    },
                                                    "tanktopStength": "Frame 3,5: 25.1 t/m²; Frame 2,4: 18.3 t/m²",
                                                    "hatchCoverStrength": "H1-5 4.0t/m2",
                                                    "upperDeckStrength": "3.50 t/m2",
                                                    "tanktopDimensions": {
                                                        "hold1": "18.2 m * 17.3 m",
                                                        "hold2": "16.2 m * 11.4 m",
                                                        "hold3": "17.2 m * 14 m",
                                                        "hold4": "13.2 m * 18.6 m",
                                                        "hold5": "15.2 m * 13.1 m"
                                                    },
                                                    "fireFightingSystem": {
                                                        "erm": "CO 2 / FIXED LOCAL APPLICATION/SW Hydrant/ Portable Fire Extinguisher/ Fire Detecting System",
                                                        "cargoHold": "SW Hydrant and CO2 Fire Extinguishing System",
                                                        "deckArea": "SW Hydrant"
                                                    }
                                                },
                                                "companyDetails": {
                                                    "name": "Uni-Asia Holdings Limited | Uni-Asia Shipping Limited",
                                                    "address": "30/F, Prosperity Millenia Plaza, 663 King's Road, North Point, Hong Kong | T +852 2528 5016 | F +852 2528 5020",
                                                    "website": "www.uni-asia.com | www.uniasiashipping"
                                                }
                                            }        
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomPdfResponseTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))
                    )
            }
    )
    public ResponseEntity<?> createShipsParticulars(@RequestBody @Valid ShipsDetailsTO shipsDetailsTO) {
        return imoFalDocumentsService.createShipsParticulars(shipsDetailsTO);
    }


    //    GET DOCUMENTS
//    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    @GetMapping
    @Operation(
            summary = "Download a PDF document",
            description = "Returns the requested PDF document."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "PDF file downloaded successfully.",
                    content = @Content(
                            mediaType = "application/pdf"
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),

            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseTO.class))),
    })
    public ResponseEntity<byte[]> getDocument(@RequestParam String pdfName) {
        ResponseEntity<byte[]> document = imoFalDocumentsService.getDocument(pdfName);

        if (document.getStatusCode() == HttpStatus.OK) {
            byte[] body = document.getBody();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=" + pdfName)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(body);
        }

        return document;

    }


}

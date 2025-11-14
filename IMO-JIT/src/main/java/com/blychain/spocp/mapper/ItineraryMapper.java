package com.blychain.spocp.mapper;

import com.blychain.spocp.entity.Itinerary;
import com.blychain.spocp.transferObject.ItineraryTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface ItineraryMapper {


    @Mapping(target = "voyage", ignore = true)
    Itinerary dtoToItinerary(ItineraryTO itineraryTO);

    ItineraryTO itineraryToDto(Itinerary itinerary);

}

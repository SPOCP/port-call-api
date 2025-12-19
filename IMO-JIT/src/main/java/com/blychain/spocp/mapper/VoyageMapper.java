package com.blychain.spocp.mapper;

import com.blychain.spocp.entity.Voyage;
import com.blychain.spocp.transferObject.VoyageTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VoyageMapper {

    Voyage dtoToVoyage(VoyageTO voyageTO);

    VoyageTO voyageToDto(Voyage voyage);

}

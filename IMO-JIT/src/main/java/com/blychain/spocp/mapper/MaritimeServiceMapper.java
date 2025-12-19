package com.blychain.spocp.mapper;

import com.blychain.spocp.entity.MaritimeService;
import com.blychain.spocp.transferObject.MaritimeServiceTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MaritimeServiceMapper {

    @Mapping(target = "portCall", ignore = true)
    MaritimeService dtoToMaritimeService(MaritimeServiceTO maritimeServiceTO);

    MaritimeServiceTO maritimeServiceToDto(MaritimeService maritimeService);
}

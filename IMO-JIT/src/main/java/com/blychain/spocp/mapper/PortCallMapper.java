package com.blychain.spocp.mapper;


import com.blychain.spocp.entity.PortCall;
import com.blychain.spocp.transferObject.PortCallTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface PortCallMapper {

    @Mapping(target = "voyage", ignore = true)
    PortCall dtoToPortCall(PortCallTO portCallTO);

    PortCallTO portCallToDto(PortCall portCall);

}

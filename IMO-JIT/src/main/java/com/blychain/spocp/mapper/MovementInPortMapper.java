package com.blychain.spocp.mapper;

import com.blychain.spocp.entity.MovementInPort;
import com.blychain.spocp.transferObject.MovementInPortTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovementInPortMapper {

    @Mapping(target = "portCall", ignore = true)
    MovementInPort dtoToMovementInPort(MovementInPortTO movementInPortTO);

    MovementInPortTO movementInPortToDto(MovementInPort movementInPort);

}

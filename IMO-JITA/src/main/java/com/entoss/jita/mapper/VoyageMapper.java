package com.entoss.jita.mapper;

import com.entoss.jita.entity.Voyage;
import com.entoss.jita.transferObject.VoyageTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface VoyageMapper {
    Voyage dtoToVoyage(VoyageTO voyageTO);

    VoyageTO voyageToDto(Voyage voyage);

}

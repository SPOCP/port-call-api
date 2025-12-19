package com.blychain.spocp.transferObject.documents.dangerousgoodsmanifest;

import com.blychain.spocp.transferObject.documents.DocTypeTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DangerousGoodsManifestTO {

    @Valid
    @NotNull(message = "The docType cannot be null")
    private DocTypeTO docType;

    @Valid
    @NotNull(message = "The voyageInformation cannot be null")
    private DGVoyageInformationTO voyageInformation;

    @Valid
    @NotEmpty(message = "The dangerousGoods cannot be empty")
    private List<DangerousGoodsTO> dangerousGoods;

    @Valid
    @NotNull(message = "The shippingAgentDetails cannot be null")
    private ShippingAgentDetailsTO shippingAgentDetails;
}

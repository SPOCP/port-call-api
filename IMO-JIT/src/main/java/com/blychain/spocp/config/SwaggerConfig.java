package com.blychain.spocp.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi imoJitApi() {
        return GroupedOpenApi.builder()
                .group("1 - IMO-JIT")
                .pathsToMatch("/jit/**")
                .addOpenApiCustomizer(openApi -> openApi.info(new io.swagger.v3.oas.models.info.Info()
                        .title("SPOCP JIT API")
                        .version("0.0.1")
                        .description("""
                        This API is intended for interactions between a port authority and vessel operator. Supported operations:

                        - Voyage Request  
                        - Voyage Update  
                        - Voyage Cancellation  
                        - Sub-model creation, update and deletion  

                        ## 📘 API Standard  
                        - This API adheres to the IMO Compendium JIT Standard  
                        - Implemented using the IMO Compendium JIT UML diagrams ([Diagram](https://imocompendium.imo.org/public/IMO-Compendium/Draft/index.htm))  
                        - More details: [IMO Compendium Website](https://imocompendium.imo.org/public/IMO-Compendium/Draft/index.htm)
                        """)))
                .build();
    }

    @Bean
    public GroupedOpenApi imoFalApi() {
        return GroupedOpenApi.builder()
                .group("2 - IMO-FAL")
                .pathsToMatch("/doc/**")
                .addOpenApiCustomizer(openApi -> openApi.info(new io.swagger.v3.oas.models.info.Info()
                        .title("IMO FAL Documents API")
                        .version("0.0.1")
                        .description("""
                        This API is intended to generate and manage IMO FAL documents required for vessel arrival and departure reporting.

                        ## 📄 IMO FAL Standard Documents (7)  
                        The following seven documents follow the IMO FAL Compendium Standard:
                        - General Declaration  
                        - Cargo Declaration  
                        - Ship Stores Declaration  
                        - Crew Effects Declaration  
                        - Crew List  
                        - Passenger List  
                        - Dangerous Goods Manifest  

                        ## 📝 Custom-Defined Document  
                        In addition to the standard documents, the custom-defined document:
                        - Ship Particulars  

                        ## 📘 Document Standard  
                        - This follows the IMO FAL Compendium Standard 
                        - More details: [IMO Compendium Website](https://imocompendium.imo.org/public/IMO-Compendium/Draft/index.htm)
                        """)))
                .build();
    }

}

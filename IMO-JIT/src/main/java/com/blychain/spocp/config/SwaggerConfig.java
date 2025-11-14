package com.blychain.spocp.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("SPOCP JITA API")
                        .version("0.0.1")
                        .description("""
                               This API is intended as an API between a port authority and vessel operator. The process includes:
                                                               
                               - Voyage request
                                                               
                               - Voyage update
                                                               
                               - Voyage cancellation
                               
                               - and also sub-model creation, updation and deletion.
                                                               
                               **API Standard**
                               - This API follows the IMO Compendium JITA Standard
                                                               
                               - Implemented using IMO Compendium JITA Standard UML Diagram under IMO sub-models - [Diagram](https://imocompendium.imo.org/public/IMO-Compendium/Draft/index.htm)
                                                               
                               - IMO Compendium (IMO) - [Website](https://imocompendium.imo.org/public/IMO-Compendium/Draft/index.htm)
                                """));
    }
}

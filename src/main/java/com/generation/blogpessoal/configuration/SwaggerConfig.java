package com.generation.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {



    @Bean
    public OpenAPI springNaturebaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Blog Pessoal")
                        .description("Projeto Blog Pessoal - Generation Brasil")
                        .version("v0.0.1")
                        .license(new License()
                                .name("NeoCamp-MLB")
                                .url("https://brazil.generation.org/"))
                        .contact(new Contact()
                                .name("Blog Pessoal - Silvo Julio")
                                .url("https://github.com/SilvioJulioSantos")
                                .email("silvio.dossantoss@mercacolivre.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Silvio Julio")
                        .url("https://github.com/SilvioJulioSantos/spring_boot/tree/main/blogpessoal"));
    }

    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();

                apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201", createApiResponse("Objeto persistido!"));
                apiResponses.addApiResponse("204", createApiResponse("Objeto excluido!"));
                apiResponses.addApiResponse("400", createApiResponse("Erro na requisi????o!"));
                apiResponses.addApiResponse("401", createApiResponse("Acesso n??o autorizado!"));
                apiResponses.addApiResponse("404", createApiResponse("Objeto n??o encontrado!"));
                apiResponses.addApiResponse("500", createApiResponse("Erro na aplica????o!"));
            }));
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}
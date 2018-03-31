package com.edoctor.conf;

/**
 * Created by haoyifen on 16-9-28 2016 下午5:43
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

     @Bean
     public Docket restApi() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .genericModelSubstitutes(DeferredResult.class)
                 .useDefaultResponseMessages(false)
                 .forCodeGeneration(false)
                 .securitySchemes(newArrayList(apiKey()))
                 .securityContexts(newArrayList(securityContext()))
                 .pathMapping("/")
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.edoctor.api"))
                 .build()
                 .apiInfo(apiInfo());

     }

    private ApiKey apiKey() {
        return new ApiKey("api_key", "api_key", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/*.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("api_key", authorizationScopes));
    }


     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("天津电信电管医生系统数据接口文档")
                 .description("天津电信电管医生-天津大学TANK实验室合作，天津电信电管医生物联网开放数据平台")
//                 .contact(new Contact("dongyuguo", "tanklab.tju.edu.cn", "dongyuguo@tju.edu.cn"))
//                 .license("Apache 2.0")
//                 .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                 .version("1.0")
                 .build();
     }

}

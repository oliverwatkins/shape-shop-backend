package com.shapeshop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        ffs
        registry.addResourceHandler("/**")
                .addResourceLocations("file:images/")
                .addResourceLocations("file:images/higgins/")
                .addResourceLocations("file:alpenhof/image/")
                .addResourceLocations("file:higgins/image/")
                .addResourceLocations("classpath:/static/");
    }
}

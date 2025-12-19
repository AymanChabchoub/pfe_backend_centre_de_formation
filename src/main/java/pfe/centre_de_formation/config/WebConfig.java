package pfe.centre_de_formation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "/uploads/cv/**" -> dossier physique "uploads/cv/"
        registry.addResourceHandler("/uploads/cv/**")
                .addResourceLocations("file:uploads/cv/"); // "file:" pour dossier externe
    }
}

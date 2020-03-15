package me.rn00n.WebMvcConfigurer.ResourceHandler;

import me.rn00n.WebMvcConfigurer.WebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.concurrent.TimeUnit;

public class ResourceHandlerWebConfig {
//    @Bean
//    public WebConfig webConfig() {
//        return new WebConfig(){
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/mobile1/**")
//                        .addResourceLocations("classpath:/mobile/")
//                        .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
//            }
//        };
//    }
}
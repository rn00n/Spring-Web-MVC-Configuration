package me.rn00n.WebMvcConfigurer;

import me.rn00n.WebMvcConfigurer.Formatter.PersonFormatter;
import me.rn00n.WebMvcConfigurer.HandlerInterceptor.AnotherInterceptor;
import me.rn00n.WebMvcConfigurer.HandlerInterceptor.GreetingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
//@EnableWebMvc// 이 애노테이션을 사용하면 Spring Boot의 WebMvcConfigurer 자동설정을 사용할 수 없다
public class WebConfig implements WebMvcConfigurer {

    /*Formatter*/
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new PersonFormatter()); //Bean으로 등록해도 된다.
    }

    /*HandlerInterceptor*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new AnotherInterceptor())
                .addPathPatterns("/hi")
                .order(-1);
    }

    /*ResourceHandler*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**")
                .addResourceLocations("classpath:/mobile/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES))
                .resourceChain(true)//운영중이라면 true, 개발중이라면 false
                ;
    }

    /*HttpMessageConverter
    * 이 메서드를 구현하면 기본 메시지 컨버터는 사용이 불가*/
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //사용 안함
    }
    /*이 메스드를 구현해야 기본 메시지 컨버터 사용 가능*/
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //이 경우도 많이 사용하지 않는다
    }

    /*HttpMessageConverter_XML*/
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan(Person.class.getPackageName());
        return jaxb2Marshaller;
    }
}


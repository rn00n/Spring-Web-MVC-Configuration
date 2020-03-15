package me.rn00n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //Sprinig Web MVC Configuration 사용가이드
    //1. Spring Boot를 사용중이라면 application.properties에서 key 값으로 설정 변경이 가능한가 확인
    //2. WebMvcConfigurer 구현
    //3. @Bean으로 설정파일 등록
}

package me.rn00n.WebMvcConfigurer.HandlerInterceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//handler mapping이란 어떠한 요청을 처리할 핸들러를 찾아주는 역할
//핸들러 인터셉터는 핸들러 매핑이 찾아주는 핸들러에 인터셉터들을 적용해준다
//핸들러의 요청처리 전 후로 부가적인 작업을 할 수 있다.
//요청 처리 전에
@RestController
public class HandlerInterceptorController {
    //HandlerInterceptor
    //1. preHandle1 메서드 (전처리 작업)
    //1. preHandle2 메서드 (전처리 작업)
//    핸들러의 정보 제공
    //요청처리
    //2. postHandler2 메서드 (후처리 작업)
    //2. postHandler1 메서드 (후처리 작업)
//    modelAndView 제공 (커스터마이징 가능, model 정보추가, view 조작)
    //뷰 렌더링 (RestController 는 View 랜더링이 없다)
    //3. afterCompletion2
    //3. afterCompletion1

    //비동기 요청 처리시 post 와 after 가 없다

    //서블릿 필터와의 차이
    //핸들러 인터셉터의 템플릿이 서블릿 필터보다 구체적인 처리가 가능하다.
    //해들러에 따라 특정 로직을 변경해야한다면 핸들러 인터셉터를 사용하는것이 좋다.
    //spring 에 특화되어있는 정보와 관련이 "없으"면 서블릿 필터를 사용하는것이 좋다. (일반적인 로직)

    //예) XXS 를 차단할 수 있는기능같은 경우 Servlet Filter
    //
    @GetMapping("/hello6") //handler
    public String hello6() {
        return "hello6";
    }
}

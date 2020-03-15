package me.rn00n.WebMvcConfigurer.HttpMessageConverter;

import me.rn00n.WebMvcConfigurer.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpMessageConverterController {
    @GetMapping("/message")
//    @ResponseBody //리턴값을 응답의 본문으로 넣어준다 //RestController 에는 기본적으로 붙어있다
    public String message(@RequestBody String body) {
        return body;
    }

    /*Json
    * 들어오는값도 json
    * 반환하는 값도 json*/
    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person) {
        return person;
    }

    /*XML*/
    @GetMapping("/xmlMessage")
    public Person xmlMessage(@RequestBody Person person) {
        return person;
    }
}

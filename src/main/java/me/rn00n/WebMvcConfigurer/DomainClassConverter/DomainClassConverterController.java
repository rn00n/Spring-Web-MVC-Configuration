package me.rn00n.WebMvcConfigurer.DomainClassConverter;

import me.rn00n.WebMvcConfigurer.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomainClassConverterController {
    @GetMapping("/hello5")
    public String hello5(@RequestParam("id") Person person) {
        return "hello5 " + person.getName();
    }
}

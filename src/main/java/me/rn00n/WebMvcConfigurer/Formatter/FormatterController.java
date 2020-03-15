package me.rn00n.WebMvcConfigurer.Formatter;

import me.rn00n.WebMvcConfigurer.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatterController {
    /*기본 핸들러*/
    @GetMapping("/hello1")
    public String hello1() {
        return "hello1";
    }
    @GetMapping("/hello2/{name}")
    public String hello2(@PathVariable String name) {
        return "hello2 " + name;
    }
    @GetMapping("/hello3/{name}")
    public String hello3(@PathVariable("name") Person person) {
        return "hello3 " + person.getName();
    }
    @GetMapping("/hello4")
    public String hello4(@RequestParam("name") Person person) {
        return "hello4 " + person.getName();
    }
}

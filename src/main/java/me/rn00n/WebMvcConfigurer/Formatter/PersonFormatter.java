package me.rn00n.WebMvcConfigurer.Formatter;

import me.rn00n.WebMvcConfigurer.Person;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

//Formatter
//(= Printer + Parser)
//객체를 문자열로 변환
//또는
//문자열을 객체로 변환
//@Component //SpringBoot 의 Spring Web MVC Configurer 기능, Boot가 알아서 Bean으로 등록해준다
public class PersonFormatter implements Formatter<Person> {
    @Override
    public Person parse(String s, Locale locale) throws ParseException {
        Person person = new Person();
        person.setName(s);

        return person;
    }

    @Override
    public String print(Person person, Locale locale) {
        return person.toString();
    }
}

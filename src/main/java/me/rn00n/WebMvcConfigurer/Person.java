package me.rn00n.WebMvcConfigurer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement //Jaxb 에게 어떠한 RootElement 가 있는지 알려줘야한다
@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}

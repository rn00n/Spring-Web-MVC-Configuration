package me.rn00n.WebMvcConfigurer.DomainClassConverter;

import me.rn00n.WebMvcConfigurer.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class DomainClassConverterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    //다른 설정이 적용되어 있는 PersonFomatter 가 등록되어잇지 않아야 한다.
    @Test
    public void hello5() throws Exception {
        Person person = new Person();
        person.setName("byungryang");

        Person personSave = personRepository.save(person);

        this.mockMvc.perform(get("/hello5")
                    .param("id", personSave.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello5 byungryang"));
    }
}
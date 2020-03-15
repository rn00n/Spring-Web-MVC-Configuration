package me.rn00n.WebMvcConfigurer.HttpMessageConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.rn00n.WebMvcConfigurer.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.oxm.Marshaller;
import org.springframework.test.web.servlet.MockMvc;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class HttpMessageConverterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void message() throws Exception {
        this.mockMvc.perform(get("/message")
                .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void jsonMessage() throws Exception {
        Person person = new Person();
        person.setId(2020l);
        person.setName("byungyrang");

        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                    .contentType(MediaType.APPLICATION_JSON) //요청한 데이터 타입
                    .accept(MediaType.APPLICATION_JSON) //이 요청에대한 응답 타입
                    .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2020l))
                .andExpect(jsonPath("$.name").value("byungyrang"));
    }
    //실제 application 에서 실행하려면 postman 을 사용한다

    @Autowired
    Marshaller marshaller;

    @Test
    public void xmlMessage() throws Exception {
        Person person = new Person();
        person.setId(2020l);
        person.setName("byungyrang");

        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);
        marshaller.marshal(person, result);

        String xmlString = stringWriter.toString();

        this.mockMvc.perform(get("/xmlMessage")
                .contentType(MediaType.APPLICATION_XML) //요청한 데이터 타입
                .accept(MediaType.APPLICATION_XML) //이 요청에대한 응답 타입
                .content(xmlString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("person/name").string("byungyrang"))
                .andExpect(xpath("person/id").string("2020"));
    }
}
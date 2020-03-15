package me.rn00n.WebMvcConfigurer.Formatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//@WebMvcTest //웹과 관련된 테스트 //bean등록시 Web에 관한 bean만 등록하기때문
@SpringBootTest
@AutoConfigureMockMvc
class FormatterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello1() throws Exception {
        this.mockMvc.perform(get("/hello1"))
                .andDo(print())
                .andExpect(content().string("hello1"));
    }
    @Test
    public void hello2() throws Exception {
        this.mockMvc.perform(get("/hello2/byungryang"))
                .andDo(print())
                .andExpect(content().string("hello2 byungryang"));
    }
    @Test
    public void hello3() throws Exception {
        this.mockMvc.perform(get("/hello3/byungryang"))
                .andDo(print())
                .andExpect(content().string("hello3 byungryang"));
    }
    @Test
    public void hello4() throws Exception {
        this.mockMvc.perform(get("/hello4")
        .param("name", "byungryang"))
                .andDo(print())
                .andExpect(content().string("hello4 byungryang"));
    }
}
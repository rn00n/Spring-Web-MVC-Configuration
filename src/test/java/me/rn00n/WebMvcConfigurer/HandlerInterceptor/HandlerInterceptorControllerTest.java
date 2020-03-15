package me.rn00n.WebMvcConfigurer.HandlerInterceptor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
class HandlerInterceptorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello6() throws Exception {
        this.mockMvc.perform(get("/hello6"))
                .andDo(print())
                .andExpect(content().string("hello6"));
    }
}
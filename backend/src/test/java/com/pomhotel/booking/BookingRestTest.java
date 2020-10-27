package com.pomhotel.booking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingRestTest {

    @Autowired
    private MockMvc mockMvc;

    /*@Test
    public void TestGetBooks() throws Exception{
        this.mockMvc.perform (get("/booknow"))
            .param("name","Spring values")  //ejemplo
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").value("Hello world"));
    }*/


}

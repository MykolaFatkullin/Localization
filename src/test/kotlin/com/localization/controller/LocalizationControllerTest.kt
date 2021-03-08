package com.localization.controller

import org.hamcrest.Matchers.containsString
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import java.nio.charset.StandardCharsets.UTF_8


@SpringBootTest
@AutoConfigureMockMvc
internal class LocalizationControllerTest(
    @Autowired val mockMvc: MockMvc,
) {
    @Test
    fun getNameOfCountry() {
        mockMvc.perform(get("/country-name?language=en&iso=IN")).andDo(print()).andExpect(status().isOk)
            .andExpect(content().string(containsString("India")))
        mockMvc.perform(get("/country-name?language=en&iso=AU")).andDo(print()).andExpect(status().isOk)
            .andExpect(content().string(containsString("Australia")))
        mockMvc.perform(get("/country-name?language=en&iso=UA")).andDo(print()).andExpect(status().isOk)
            .andExpect(content().string(containsString("Ukraine")))

    }
}
package com.my.training.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {


    private MockMvc mockMvc;

    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new HomeController())
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void expect_redirectWelcomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/welcome"));
    }

    @Test
    public void expect_returnWelcomePage() throws Exception {
        mockMvc.perform(get("/welcome"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("welcome"));
    }

    @Test
    public void expect_returnSignInPage() throws Exception {
        mockMvc.perform(get("/signin"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("signin"));
    }
}
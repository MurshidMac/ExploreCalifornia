package com.example.ec.explocali.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
public class TourControllerTest {

    @InjectMocks
    private TourController tourcontroller;

    private MockMvc mvc;

    @Before
    public void setup() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(tourcontroller).build();
    }

    @Test
    public void getAllTours() throws  Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/tours")
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));

        // Adding the specific test output.

    }
}
package com.si.distance.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DistanceController.class)
public class DistanceControllerTests {

  @Autowired
  private MockMvc mvc;
  
  @Test
  public void basicCalculate() throws Exception 
  {
    mvc.perform(MockMvcRequestBuilders
              .get("/calculate")
              .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.distance").value(0))
        .andExpect(MockMvcResultMatchers.jsonPath("$.returnUnit").value("METERS"));
  }

}
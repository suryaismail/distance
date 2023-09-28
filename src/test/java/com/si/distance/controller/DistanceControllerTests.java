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
              .param("distanceA", "2.3")
              .param("distanceB", "3.4")
              .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.distance").value(5.7))
        .andExpect(MockMvcResultMatchers.jsonPath("$.returnUnit").value("METERS"));
  }
  
  @Test
  public void badDistance() throws Exception 
  {
    mvc.perform(MockMvcRequestBuilders
              .get("/calculate")
              .param("distanceA", "2.3")
              .param("distanceB", "-3.4")
              .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }
  
  @Test
  public void badUnit() throws Exception 
  {
    mvc.perform(MockMvcRequestBuilders
              .get("/calculate")
              .param("distanceA", "2.3")
              .param("distanceB", "3.4")
              .param("unitA", "METER")
              .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }
}
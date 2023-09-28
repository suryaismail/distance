package com.si.distance.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceCalculatorTest {

  DistanceCalculator calculator;

  @BeforeEach                                         
  void setUp() {
      calculator = new DistanceCalculator();
  }
  
  @Test                                               
  @DisplayName("Add meters should work")   
  void givenInputInMetersAndReturnUnitMeters_whenCalculateDistance_thenReturnMeters() {
    
  }
  
  @Test                                               
  @DisplayName("Add yards should work")   
  void givenInputInYardsAndReturnUnitYards_whenCalculateDistance_thenReturnYards() {
    
  }
  
  @Test                                               
  @DisplayName("Add meter and yard, return meters should work")   
  void givenInputInMeterAndYardAndReturnUnitMeters_whenCalculateDistance_thenReturnMeters() {
    
  }
  
  @Test                                               
  @DisplayName("Add yard and meter, return yards should work")   
  void givenInputInYardAndMeterAndReturnUnitMeters_whenCalculateDistance_thenReturnMeters() {
    
  }
  
  @Test                                               
  @DisplayName("Invalid distance, should throw exceptioin")   
  void givenInvalidDistance_whenCalculateDistance_thenThrowException() {
    
  }
  
  @Test                                               
  @DisplayName("Invalid unit, should throw exceptioin")   
  void givenInvalidUnit_whenCalculateDistance_thenThrowException() {
    
  }
  
  @Test                                               
  @DisplayName("Invalid return unit, should throw exceptioin")   
  void givenInvalidReturnUnit_whenCalculateDistance_thenThrowException() {
    
  }
}

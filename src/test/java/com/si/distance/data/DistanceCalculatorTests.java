package com.si.distance.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceCalculatorTests {

  DistanceCalculator calculator;

  @BeforeEach                                         
  void setUp() {
    calculator = new DistanceCalculator();
  }

  @Test                                               
  @DisplayName("Add meters should work")   
  void givenInputInMetersAndReturnUnitMeters_whenCalculateDistance_thenReturnMeters() {
    TotalDistance totalDistance = calculator.calculate(2.3, 2.4, "METERS", "METERS", "METERS");
    assertEquals(4.7, totalDistance.distance(), 0);
    assertEquals(DistanceUnit.METERS, totalDistance.returnUnit());
  }

  @Test                                               
  @DisplayName("Add yards should work")   
  void givenInputInYardsAndReturnUnitYards_whenCalculateDistance_thenReturnYards() {
    TotalDistance totalDistance = calculator.calculate(2.3, 2.4, "YARDS", "YARDS", "YARDS");
    assertEquals(4.7, totalDistance.distance(), 0);
    assertEquals(DistanceUnit.YARDS, totalDistance.returnUnit());
  }

  @Test                                               
  @DisplayName("Add meter and yard, return meters should work")   
  void givenInputInMeterAndYardAndReturnUnitMeters_whenCalculateDistance_thenReturnMeters() {
    TotalDistance totalDistance = calculator.calculate(2.3, 2.4, "METERS", "YARDS", "METERS");
    assertEquals(4.5, totalDistance.distance(), 0.1);
    assertEquals(DistanceUnit.METERS, totalDistance.returnUnit());
  }

  @Test                                               
  @DisplayName("Add yard and meter, return yards should work")   
  void givenInputInYardAndMeterAndReturnUnitMeters_whenCalculateDistance_thenReturnMeters() {
    TotalDistance totalDistance = calculator.calculate(2.3, 2.4, "YARDS", "METERS", "YARDS");
    assertEquals(4.9, totalDistance.distance(), 0.1);
    assertEquals(DistanceUnit.YARDS, totalDistance.returnUnit());
  }

  @Test                                               
  @DisplayName("Invalid distance, should throw exception")   
  void givenInvalidDistance_whenCalculateDistance_thenThrowException() {
    assertThrows(NumberFormatException.class, () -> {
      calculator.calculate(-2.3, -2.4, "METERS", "METERS", "METERS");  });
  }

  @Test                                               
  @DisplayName("Invalid unit, should throw exceptiin")   
  void givenInvalidUnit_whenCalculateDistance_thenThrowException() {
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculate(2.3, 2.4, "YARDS", "feet", "METERS");  });
  }

  @Test                                               
  @DisplayName("Invalid return unit, should throw exception")   
  void givenInvalidReturnUnit_whenCalculateDistance_thenThrowException() {
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculate(2.3, 2.4, "YARDS", "METERS", "Centimeters");  });
  }
}

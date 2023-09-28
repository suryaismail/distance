package com.si.distance.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    TotalDistance totalDistance = calculator.calculate(2.3, 2.4, DistanceUnit.METERS, DistanceUnit.METERS, DistanceUnit.METERS);
    assertEquals(4.7, totalDistance.distance(), 0.01);
    assertEquals(DistanceUnit.METERS, totalDistance.returnUnit());
  }

  @Test                                               
  @DisplayName("Add yards should work")   
  void givenInputInYardsAndReturnUnitYards_whenCalculateDistance_thenReturnYards() {
    TotalDistance totalDistance = calculator.calculate(2.3, 2.4, DistanceUnit.YARDS, DistanceUnit.YARDS, DistanceUnit.METERS);
    assertEquals(4.7, totalDistance.distance(), 0.01);
    assertEquals(DistanceUnit.YARDS, totalDistance.returnUnit());
  }

  @Test                                               
  @DisplayName("Add meter and yard, return meters should work")   
  void givenInputInMeterAndYardAndReturnUnitMeters_whenCalculateDistance_thenReturnMeters() {
    TotalDistance totalDistance = calculator.calculate(2.3, 2.4, DistanceUnit.METERS, DistanceUnit.YARDS, DistanceUnit.METERS);
    assertEquals(4.5, totalDistance.distance(), 0.1);
    assertEquals(DistanceUnit.METERS, totalDistance.returnUnit());
  }

  @Test                                               
  @DisplayName("Add yard and meter, return yards should work")   
  void givenInputInYardAndMeterAndReturnUnitMeters_whenCalculateDistance_thenReturnMeters() {
    TotalDistance totalDistance = calculator.calculate(2.3, 2.4, DistanceUnit.YARDS, DistanceUnit.METERS, DistanceUnit.METERS);
    assertEquals(4.9, totalDistance.distance(), 0.1);
    assertEquals(DistanceUnit.YARDS, totalDistance.returnUnit());
  }

  @Test                                               
  @DisplayName("Invalid distance, should throw exception")   
  void givenInvalidDistance_whenCalculateDistance_thenThrowException() {
    assertThrows(NumberFormatException.class, () -> {
      calculator.calculate(-2.3, -2.4, DistanceUnit.METERS, DistanceUnit.METERS, DistanceUnit.METERS);  });
  }

}

package com.si.distance.data;

public class DistanceCalculator {

  public TotalDistance calculate(double distanceA, double distanceB, DistanceUnit unitA, DistanceUnit unitB,
      DistanceUnit returnUnit) {
    
    if ((distanceA < 0) || (distanceB < 0)) {
      throw new NumberFormatException(
          "Distance cannot be negative");
    }
    
    return new TotalDistance(distanceA + distanceB, DistanceUnit.METERS);
  }
}

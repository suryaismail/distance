package com.si.distance.data;

public class DistanceCalculator {

  private static final double YARDS_TO_METERS = 1.094;

  public TotalDistance calculate(double distanceA, double distanceB, String unitAStr, String unitBStr,
      String returnUnitStr) {
    
    if ((distanceA < 0) || (distanceB < 0)) {
      throw new NumberFormatException(
          "Distance cannot be negative");
    }
    
    DistanceUnit unitA = DistanceUnit.valueOf(unitAStr);
    DistanceUnit unitB = DistanceUnit.valueOf(unitBStr);
    DistanceUnit returnUnit = DistanceUnit.valueOf(returnUnitStr);
    
    return calculate(distanceA, distanceB, unitA, unitB, returnUnit);
  }
  
  public TotalDistance calculate(double distanceA, double distanceB,
      DistanceUnit unitA, DistanceUnit unitB, DistanceUnit returnUnit) {

    double distanceAMeters = toMeters(distanceA, unitA);
    double distanceBMeters = toMeters(distanceB, unitB);

    return new TotalDistance(metersToUnit(distanceAMeters + distanceBMeters, returnUnit), returnUnit);
  }


  private double toMeters(double distance, DistanceUnit unit) {
    switch(unit) {
      case METERS :
        return distance;
      case YARDS :
        return distance / YARDS_TO_METERS;
    }
    return 0;
  }
  
  private double metersToUnit(double distance, DistanceUnit returnUnit) {
    switch(returnUnit) {
      case METERS :
        return distance;
      case YARDS :
        return distance * YARDS_TO_METERS;
    }    return 0;
  }
  
}

package com.si.distance.data;

import java.text.DecimalFormat;

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

    // Not sure this is the best solution but will format the answer to 2 decimal places
    // so it's nicer for the user to see
    double totalDistance = metersToUnit(distanceAMeters + distanceBMeters, returnUnit);
    DecimalFormat df = new DecimalFormat("#.##");      
    totalDistance = Double.valueOf(df.format(totalDistance));
    
    
    return new TotalDistance(totalDistance, returnUnit);
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

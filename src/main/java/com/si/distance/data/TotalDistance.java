package com.si.distance.data;


public record TotalDistance(double distance, DistanceUnit returnUnit) { 

  public TotalDistance(double distance, DistanceUnit returnUnit)
  {
    if (distance < 0) {
      throw new NumberFormatException(
          "Distance cannot be negative");
    }
    this.distance = distance;
    this.returnUnit = returnUnit;
  }
}

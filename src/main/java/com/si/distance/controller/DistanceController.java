package com.si.distance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.si.distance.data.*;

@RestController
public class DistanceController {

  @GetMapping("/calculate")
  public TotalDistance totalDistance(
      @RequestParam(value = "distanceA", defaultValue = "0") double distanceA,
      @RequestParam(value = "distanceB", defaultValue = "0") double distanceB,
      @RequestParam(value = "unitA", defaultValue = "METERS") String unitA,
      @RequestParam(value = "unitB", defaultValue = "METERS") String unitB,
      @RequestParam(value = "returnUnit", defaultValue = "METERS") String returnUnit) {

    return (new DistanceCalculator()).calculate(distanceA, distanceB, unitA, unitB, returnUnit);
  }
}
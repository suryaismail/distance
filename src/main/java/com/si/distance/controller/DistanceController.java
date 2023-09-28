package com.si.distance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.si.distance.data.*;

@RestController
public class DistanceController {

    //private static final String template = "Total distance is %s";

    @GetMapping("/calculate")
    public TotalDistance greeting(
        @RequestParam(value = "distanceA", defaultValue = "0") double distanceA,
        @RequestParam(value = "distanceB", defaultValue = "0") double distanceB,
        @RequestParam(value = "unitA", defaultValue = "meter") String unitA,
        @RequestParam(value = "unitB", defaultValue = "meter") String unitB,
        @RequestParam(value = "returnUnit", defaultValue = "meter") String returnUnit) {
        return new TotalDistance(distanceA + distanceB, DistanceUnit.METERS);
    }
}
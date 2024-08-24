package com.codingshuttle.project.uber.uberApp.strategies;

import com.codingshuttle.project.uber.uberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.RideFareSurgePricingCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy driverMatchingHighestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    private final RideFareDefaultFareCalculationStrategy rideFareDefaultFareCalculationStrategy;
    private final RideFareSurgePricingCalculationStrategy rideFareSurgePricingCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if(riderRating>=4.8){
            return driverMatchingHighestRatedDriverStrategy;
        }else{
            return driverMatchingNearestDriverStrategy;
        }
    }
    public RideFareCalculationStrategy rideFareCalculationStrategy(){

        //6PM to 9 PM
        LocalTime surgeStartTime=LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime=LocalTime.now();

        boolean isSurgeTime= currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime){
            return rideFareSurgePricingCalculationStrategy;
        }else{
            return rideFareDefaultFareCalculationStrategy;
        }

    }
}

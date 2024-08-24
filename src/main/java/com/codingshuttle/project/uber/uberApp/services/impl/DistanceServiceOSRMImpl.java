package com.codingshuttle.project.uber.uberApp.services.impl;

import com.codingshuttle.project.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
    public static final String OSRM_API="http://router.project-osrm.org/route/v1/driving/";
    @Override
    public double calculateDistance(Point source, Point destination) {
        //call the third party api to fetch the distance
        try {
            String uri=source.getX()+","+source.getY()+";"+destination.getX()+","+destination.getY();
            OSRMResponseDto osrmResponseDto = RestClient.builder()
                    .baseUrl(OSRM_API)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);
            return osrmResponseDto.getRoutes().get(0).getDistance() / 1000.0;
        }catch (Exception e){
            throw  new RuntimeException("Error getting data from OSRM "+e.getMessage());
        }
    }
}

@Data
class OSRMResponseDto {
    private List<OSRMRoutes> routes;

}

@Data
class OSRMRoutes{
    private Double distance;
}

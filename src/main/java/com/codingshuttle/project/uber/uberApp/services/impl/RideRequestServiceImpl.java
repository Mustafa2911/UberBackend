package com.codingshuttle.project.uber.uberApp.services.impl;

import com.codingshuttle.project.uber.uberApp.entities.RideRequest;
import com.codingshuttle.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.codingshuttle.project.uber.uberApp.repositories.RideRequestRepository;
import com.codingshuttle.project.uber.uberApp.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestById) {
        return rideRequestRepository.findById(rideRequestById).orElseThrow(()->new ResourceNotFoundException("RideRequest id not found with id: "+rideRequestById));
    }

    @Override
    public void update(RideRequest rideRequest) {
        RideRequest toSave=rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(()->new ResourceNotFoundException("RideRequest not found with id"));
        rideRequestRepository.save(rideRequest);
    }
}

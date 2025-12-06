package com.Anshul.controller;

import jakarta.validation.Valid;
import com.Anshul.dto.CreateRideRequest;
import com.Anshul.dto.RideResponse;
import com.Anshul.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/rides")
    public ResponseEntity<RideResponse> createRide(@Valid @RequestBody CreateRideRequest request) {
        return ResponseEntity.ok(rideService.createRide(request));
    }

    @GetMapping("/user/rides")
    public ResponseEntity<List<RideResponse>> getMyRides() {
        return ResponseEntity.ok(rideService.getMyRides());
    }

    @PostMapping("/rides/{rideId}/complete")
    public ResponseEntity<RideResponse> completeRide(@PathVariable String rideId) {
        return ResponseEntity.ok(rideService.completeRide(rideId));
    }
}

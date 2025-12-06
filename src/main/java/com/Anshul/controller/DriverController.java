package com.Anshul.controller;

import com.Anshul.dto.RideResponse;
import com.Anshul.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver/rides")
public class DriverController {

    @Autowired
    private RideService rideService;

    @GetMapping("/requests")
    public ResponseEntity<List<RideResponse>> getPendingRides() {
        return ResponseEntity.ok(rideService.getAvailableRides());
    }

    @PostMapping("/{rideId}/accept")
    public ResponseEntity<RideResponse> acceptRide(@PathVariable String rideId) {
        return ResponseEntity.ok(rideService.acceptRide(rideId));
    }
}

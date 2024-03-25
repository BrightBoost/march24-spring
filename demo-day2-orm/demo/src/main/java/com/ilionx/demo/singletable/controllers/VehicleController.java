package com.ilionx.demo.singletable.controllers;


import com.ilionx.demo.singletable.models.SingleBike;
import com.ilionx.demo.singletable.models.SingleCar;
import com.ilionx.demo.singletable.models.SingleVehicle;
import com.ilionx.demo.singletable.repositories.SingleVehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/singleVehicles")
public class VehicleController {

    private SingleVehicleRepository vehicleRepository;

    public VehicleController(SingleVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping("/car")
    public ResponseEntity<SingleVehicle> createCar(@RequestBody SingleCar car) {
        SingleVehicle savedVehicle = vehicleRepository.save(car);
        return ResponseEntity.ok(savedVehicle);
    }

    @PostMapping("/bike")
    public ResponseEntity<SingleVehicle> createBike(@RequestBody SingleBike bike) {
        SingleVehicle savedVehicle = vehicleRepository.save(bike);
        return ResponseEntity.ok(savedVehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingleVehicle> getVehicle(@PathVariable Long id) {
        SingleVehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return ResponseEntity.ok(vehicle);
    }

    // Other endpoints as needed...
}
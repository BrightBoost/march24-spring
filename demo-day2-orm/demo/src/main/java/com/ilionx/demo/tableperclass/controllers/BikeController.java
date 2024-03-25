package com.ilionx.demo.tableperclass.controllers;

import com.ilionx.demo.tableperclass.models.Bike;
import com.ilionx.demo.tableperclass.repositories.BikeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/tableBikes")
public class BikeController {

    private BikeRepository bikeRepository;

    public BikeController(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @PostMapping
    public ResponseEntity<Bike> createBike(@RequestBody Bike bike) {
        Bike savedBike = bikeRepository.save(bike);
        return ResponseEntity.ok(savedBike);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBike(@PathVariable Long id) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bike not found"));
        return ResponseEntity.ok(bike);
    }

    // Other endpoints as needed...
}

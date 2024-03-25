package com.ilionx.demo.tableperclass.repositories;

import com.ilionx.demo.tableperclass.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Repository methods can be added here
}

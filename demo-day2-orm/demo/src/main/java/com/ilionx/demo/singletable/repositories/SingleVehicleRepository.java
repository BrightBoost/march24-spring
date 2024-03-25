package com.ilionx.demo.singletable.repositories;

import com.ilionx.demo.singletable.models.SingleVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleVehicleRepository extends JpaRepository<SingleVehicle, Long> {
    // Repository methods can be added here
}

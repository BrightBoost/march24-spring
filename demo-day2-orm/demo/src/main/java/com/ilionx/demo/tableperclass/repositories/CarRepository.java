package com.ilionx.demo.tableperclass.repositories;

import com.ilionx.demo.tableperclass.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Repository methods can be added here
}
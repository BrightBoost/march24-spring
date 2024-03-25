package com.ilionx.demo.tableperclass.repositories;

import com.ilionx.demo.tableperclass.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
    // Repository methods can be added here
}
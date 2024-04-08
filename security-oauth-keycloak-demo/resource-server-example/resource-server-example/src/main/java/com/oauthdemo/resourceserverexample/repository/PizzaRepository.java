package com.oauthdemo.resourceserverexample.repository;

import com.oauthdemo.resourceserverexample.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}

package com.oauthdemo.resourceserverexample.repository;

import com.oauthdemo.resourceserverexample.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

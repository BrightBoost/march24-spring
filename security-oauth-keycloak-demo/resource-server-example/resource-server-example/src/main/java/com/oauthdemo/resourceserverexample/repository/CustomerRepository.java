package com.oauthdemo.resourceserverexample.repository;

import com.oauthdemo.resourceserverexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

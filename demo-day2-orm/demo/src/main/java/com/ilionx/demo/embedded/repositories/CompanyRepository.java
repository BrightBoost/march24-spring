package com.ilionx.demo.embedded.repositories;

import com.ilionx.demo.embedded.controllers.CompanyController;
import com.ilionx.demo.embedded.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByAddressCity(String city);
}

package com.ilionx.demo.embedded.controllers;

import com.ilionx.demo.embedded.models.Company;
import com.ilionx.demo.embedded.repositories.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {


    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company savedCompany = companyRepository.save(company);
        return ResponseEntity.ok(savedCompany);
    }

    // Add other CRUD endpoints as needed...
}
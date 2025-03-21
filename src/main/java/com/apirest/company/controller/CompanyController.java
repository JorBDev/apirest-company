package com.apirest.company.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.company.model.CompanyModel;
import com.apirest.company.service.CompanyService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/company")
@Validated
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyModel> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public CompanyModel getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public CompanyModel putMethodName(@PathVariable int id, @RequestBody CompanyModel request) {

        return companyService.updateCompanyById(request, id);
    }

    @PostMapping
    public CompanyModel saveCompany(@Valid @RequestBody CompanyModel company) {
        return companyService.saveCompany(company);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable int id) {
        return companyService.deleteCompany(id);
    }
}

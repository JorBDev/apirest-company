package com.apirest.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.company.model.CompanyModel;

@Repository
public interface ICompanyResposity extends JpaRepository<CompanyModel, Integer> {

}

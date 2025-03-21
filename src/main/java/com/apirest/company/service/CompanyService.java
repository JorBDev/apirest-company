package com.apirest.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.company.model.CompanyModel;
import com.apirest.company.repository.ICompanyResposity;

@Service
public class CompanyService {

    private final ICompanyResposity companyRepository;

    public CompanyService(ICompanyResposity companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyModel> getAllCompanies() {
        return companyRepository.findAll();
    }

    public CompanyModel getCompanyById(int id) {
        return companyRepository.findById(id).orElse(null);
    }

    public CompanyModel saveCompany(CompanyModel company) {
        return companyRepository.save(company);
    }

    public CompanyModel updateCompanyById(CompanyModel company, int id) {
        Optional<CompanyModel> existingCompany = companyRepository.findById(id);
        if (existingCompany.isPresent()) {
            CompanyModel companyUpdate = existingCompany.get();
            companyUpdate.setCodigo_company(company.getCodigo_company());
            companyUpdate.setName_company(company.getName_company());
            companyUpdate.setDescription_company(company.getDescription_company());

            return companyRepository.save(companyUpdate);
        }
        return null;
    }

    public String deleteCompany(int id) {
        try {
            companyRepository.deleteById(id);
            return "Empresa eliminada correctamente";
        } catch (Exception e) {
            return "Error al eliminar la empresa";
        }
    }
}

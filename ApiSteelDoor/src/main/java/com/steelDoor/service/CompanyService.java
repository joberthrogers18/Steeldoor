package com.steelDoor.service;

import com.steelDoor.model.Company;
import com.steelDoor.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
        CompanyRepository companyRepository;

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long companyId) {
        return companyRepository.findById(companyId);
    }

    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }

    public Company updateCompany(Long companyId, Company company) {
        Company currentCompany = companyRepository.findById(companyId).get();
        currentCompany.setName(company.getName());
        currentCompany.setAddress(company.getAddress());

        return companyRepository.save(currentCompany);
    }

}

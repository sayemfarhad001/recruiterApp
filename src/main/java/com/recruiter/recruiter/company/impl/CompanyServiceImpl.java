package com.recruiter.recruiter.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.recruiter.recruiter.company.Company;
import com.recruiter.recruiter.company.CompanyRepository;
import com.recruiter.recruiter.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    
    private CompanyRepository companyRepository;


    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()){
            Company company = companyOptional.get();

            company.setDescription(updatedCompany.getDescription());
            company.setName(updatedCompany.getName());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }



}

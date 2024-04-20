package com.aks.jobApplication.Company.service;

import java.util.List;
import java.util.Optional;

import com.aks.jobApplication.Company.Entity.Company;


public interface CompanyServices {

   List<Company> getAllCompany();

  void saveCompany(Company company);

  boolean updateCompany(Company company,Long id);

  boolean deleteCompanyById(Long id);

  Optional<Company> getCompanyById(Long id);

}

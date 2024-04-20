package com.aks.jobApplication.Company.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.aks.jobApplication.Company.Entity.Company;
import com.aks.jobApplication.Company.Repo.CompanyRepo;
import com.aks.jobApplication.Company.service.CompanyServices;


@Service
public class CompanyServicesImpl implements CompanyServices {

  CompanyRepo companyRepo;

  



  public CompanyServicesImpl(CompanyRepo companyRepo) {
    this.companyRepo = companyRepo;
  }





  @Override
  public List<Company> getAllCompany() {
    // TODO Auto-generated method stub
    return companyRepo.findAll();
  }





  @Override
  public void saveCompany(Company company) {
    // TODO Auto-generated method stub
    companyRepo.save(company);
    
  }





  @Override
  public boolean updateCompany(Company company, Long id) {
    // TODO Auto-generated method stub
     Optional<Company> comp = companyRepo.findById(id);
     if(comp.isPresent()){
      Company c=comp.get();
      c.setName(company.getName());
      c.setDescription(company.getDescription());
      companyRepo.save(c);
      return true;

     }
     return false;
  }





  @Override
  public boolean deleteCompanyById(Long id) {
    // TODO Auto-generated method stub
    if(companyRepo.findById(id).isPresent()){
    companyRepo.deleteById(id);
    return true;

    }
    return false;

  
  }





  @Override
  public Optional<Company> getCompanyById(Long id) {
    // TODO Auto-generated method stub
    return companyRepo.findById(id);
  }

}

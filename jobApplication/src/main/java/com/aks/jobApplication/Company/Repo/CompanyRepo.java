package com.aks.jobApplication.Company.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aks.jobApplication.Company.Entity.Company;



public interface CompanyRepo extends JpaRepository<Company,Long> {

  

  

}

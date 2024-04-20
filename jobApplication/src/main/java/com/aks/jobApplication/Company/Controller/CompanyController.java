package com.aks.jobApplication.Company.Controller;


import org.springframework.web.bind.annotation.RestController;

import com.aks.jobApplication.Company.Entity.Company;
import com.aks.jobApplication.Company.service.CompanyServices;
import com.aks.jobApplication.Company.service.impl.CompanyServicesImpl;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;










@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyServices companyServices;



@GetMapping
public ResponseEntity getCompany() {

    return ResponseEntity.ok(companyServices.getAllCompany());



}

@PostMapping
public ResponseEntity saveCompany(@RequestBody Company company) {
    //TODO: process POST request
    try {
        companyServices.saveCompany(company);
        return ResponseEntity.ok("Success");
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
        return new ResponseEntity<>("fialed ",HttpStatus.NOT_FOUND);
        
    }




}
@PutMapping("{id}")
public ResponseEntity updateEntity(@RequestBody Company company,@PathVariable Long id){
    companyServices.updateCompany(company, id);
    return new ResponseEntity<>("Success",HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity getMethodName(@PathVariable Long id) {

    
    return new ResponseEntity<>(companyServices.deleteCompanyById(id),HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity getCompany(@PathVariable Long id) {

    Optional<Company> company=companyServices.getCompanyById(id);
    

    if(company.isPresent()){
        return new ResponseEntity<>(company,HttpStatus.OK);
    }
    else
    {
        return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
    }

}




}

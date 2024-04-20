package com.aks.jobApplication.Controller;


import org.springframework.web.bind.annotation.RestController;

import com.aks.jobApplication.Entity.Job;
import com.aks.jobApplication.Services.JobServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@RestController
@RequestMapping("/job")
public class JobController {

  @Autowired
  private JobServices jobServices;

  

  @GetMapping
  public ResponseEntity findAll(){
    return ResponseEntity.ok(jobServices.findAll());
  }

  @PostMapping
  public ResponseEntity createJobs(@RequestBody Job job) {
      //TODO: process POST request
    jobServices.createJobs(job);
    return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity findById(@PathVariable Long id) {

    Job job=jobServices.findById(id);
      
      if(job!=null)
      return new ResponseEntity<>(job,HttpStatus.OK);
      else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteJob(@PathVariable Long id){
    if(jobServices.deleteJobById(id)){
    return new ResponseEntity<>("job deleted successfully",HttpStatus.OK);
  }
    return new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
  }

  @PutMapping("/{id}")
  public ResponseEntity updateById(@PathVariable Long id, @RequestBody Job job) {
      //TODO: process PUT request
      if(jobServices.updateById(id,job))
        return new ResponseEntity<>("Value updated",HttpStatus.OK);
      return new ResponseEntity<>("Error" ,HttpStatus.NOT_FOUND);
  }
  
  

}

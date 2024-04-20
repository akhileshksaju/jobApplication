package com.aks.jobApplication.Services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aks.jobApplication.Entity.Job;
import com.aks.jobApplication.Repo.JobRepo;
import com.aks.jobApplication.Services.JobServices;

@Service
public class JobServicesImpl implements JobServices {



  private List<Job> jobs= new ArrayList<>();

  JobRepo jobRepo;

  
  
 

  public JobServicesImpl(JobRepo jobRepo) {
    this.jobRepo = jobRepo;
  }

  @Override
  public List<Job> findAll() {
    // TODO Auto-generated method stub
    
    return jobRepo.findAll();
  }

  @Override
  public void createJobs(Job job) {
    // TODO Auto-generated method stub
    
    jobRepo.save(job);
  }

  @Override
  public Job findById(Long id) {
    // // TODO Auto-generated method stub
    // for(Job j:jobs){
    //   if(j.getId().equals(id))
    //   return j;
    // }
    // return null;
    

    return jobRepo.findById(id).orElse(null);



  }

  @Override
  public boolean deleteJobById(Long id) {
    // TODO Auto-generated method stub
    // for(Job j:jobs){
    //   if(j.getId().equals(id)){
    //     jobs.remove(j);
    //   }
    //   return true;
    // }
    // return false;

    try {
      jobRepo.deleteById(id);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;



      // TODO: handle exception
    }







  }

  @Override
  public boolean updateById(Long id, Job job) {
    // TODO Auto-generated method stub
    
      Optional<Job> jobOptional = jobRepo.findById(id);
      
      if(jobOptional.isPresent()){
        Job j = jobOptional.get();
        j.setName(job.getName());
        j.setMinSalary(job.getMinSalary());
        j.setMaxSalary(job.getMaxSalary());
        j.setDescription(job.getDescription());
        j.setLocation(job.getLocation());
        jobRepo.save(j);
        return true;
      }
    
    return false;



  }

}

package com.aks.jobApplication.Services;

import java.util.List;

import com.aks.jobApplication.Entity.Job;

public interface JobServices {
  List<Job> findAll();
  void createJobs(Job job);
  Job findById(Long id);
  boolean deleteJobById(Long id);
  boolean updateById(Long id, Job job);

}

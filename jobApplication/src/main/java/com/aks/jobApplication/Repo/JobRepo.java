package com.aks.jobApplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aks.jobApplication.Entity.Job;

public interface JobRepo extends JpaRepository<Job,Long> {

}

package com.aks.jobApplication.Review.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aks.jobApplication.Review.Entity.Review;


@Repository
public interface ReviewRepo extends JpaRepository<Review,Long>{

}

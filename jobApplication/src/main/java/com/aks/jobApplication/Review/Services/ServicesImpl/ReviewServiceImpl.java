package com.aks.jobApplication.Review.Services.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aks.jobApplication.Review.Entity.Review;
import com.aks.jobApplication.Review.Repo.ReviewRepo;
import com.aks.jobApplication.Review.Services.ReviewServices;

@Service
public class ReviewServiceImpl implements ReviewServices{

  
  ReviewRepo reviewRepo;

  @Override
  public Optional<Review> getReviewByID(Long id) {
    // TODO Auto-generated method stub

    return reviewRepo.findById(id);
  
  }

  @Override
  public List<Review> getAllReview() {
    // TODO Auto-generated method stub
    return reviewRepo.findAll();
  }

  @Override
  public Review saveReview(Review review) {
    // TODO Auto-generated method stub

     return reviewRepo.save(review);

  }

  @Override
  public void deleteReviewById(Long id) throws NullPointerException{
    // TODO Auto-generated method stub
    reviewRepo.deleteById(id);
  }

  @Override
  public Boolean updateReview(Review review, Long id) {
    // TODO Auto-generated method stub

    Optional<Review> r = reviewRepo.findById(id);
    if(r.isPresent()){
      r.get().setDiscription(review.getDiscription());
      reviewRepo.save(r.get());
      return true;
    }
    return false;
    


  }

}

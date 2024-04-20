package com.aks.jobApplication.Review.Services;



import java.util.List;
import java.util.Optional;


import com.aks.jobApplication.Review.Entity.Review;



public interface ReviewServices {

  Optional<Review> getReviewByID(Long id);
  List<Review> getAllReview();
  Review saveReview(Review review);
  void deleteReviewById(Long id);
  Boolean updateReview(Review review,Long id);  



}

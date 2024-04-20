package com.aks.jobApplication.Review.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.aks.jobApplication.Review.Entity.Review;
import com.aks.jobApplication.Review.Services.ReviewServices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/review")
public class ReviewController {


  @Autowired
  private ReviewServices reviewServices;



  @PostMapping
  public ResponseEntity SaveReview(@RequestBody Review review) {
      //TODO: process POST request
      
      return new ResponseEntity<>(reviewServices.saveReview(review),HttpStatus.OK);
  }
  
}

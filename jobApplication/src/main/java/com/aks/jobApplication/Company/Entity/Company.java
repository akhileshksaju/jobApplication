package com.aks.jobApplication.Company.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.aks.jobApplication.Entity.*;
import com.aks.jobApplication.Review.Entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "company_table")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;


  @JsonIgnore
  @OneToMany(mappedBy = "company")
  private List<Job> jobs;

  @OneToMany
  @JsonIgnore
  private List<Review> reviews;


}

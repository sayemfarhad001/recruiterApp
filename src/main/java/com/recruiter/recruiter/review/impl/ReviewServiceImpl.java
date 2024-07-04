package com.recruiter.recruiter.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recruiter.recruiter.company.Company;
import com.recruiter.recruiter.company.CompanyService;
import com.recruiter.recruiter.review.Review;
import com.recruiter.recruiter.review.ReviewRepository;
import com.recruiter.recruiter.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;    //final suggested by project organizer - 5:35:23
    private final CompanyService companyService;    

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company =  companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review); 
            return true;
        }
        return false;
    }

}

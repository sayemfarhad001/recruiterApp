package com.recruiter.recruiter.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recruiter.recruiter.review.Review;
import com.recruiter.recruiter.review.ReviewRepository;
import com.recruiter.recruiter.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

}

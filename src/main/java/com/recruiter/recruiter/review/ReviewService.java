package com.recruiter.recruiter.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);

    // boolean updateReview(Review review, Long id);
    Review getReview(Long companyId, Long reviewId);
    // boolean deleteReviewById(Long id);
    
}

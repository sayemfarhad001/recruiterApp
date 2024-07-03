package com.recruiter.recruiter.job;

import org.springframework.data.jpa.repository.JpaRepository;

//JPA REPOSITORY INTERFACE  
public interface JobRepository extends JpaRepository <Job, Long> {
}

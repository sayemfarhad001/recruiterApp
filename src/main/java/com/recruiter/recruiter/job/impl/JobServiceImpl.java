package com.recruiter.recruiter.job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.recruiter.recruiter.job.Job;
import com.recruiter.recruiter.job.JobRepository;
import com.recruiter.recruiter.job.JobService;



// // VERSION 2 - MINIMIZED WITH JPA REPO
@Service
public class JobServiceImpl implements JobService {

    //WE HAVE H2 DATABASE WWITH JPA
    // private List<Job> jobs= new ArrayList();
    JobRepository jobRepository;    //DEFINE JPA REPO obj
    
    //Create constructor injecting JPA Repo - Autowired in runtime
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // private Long nextId = 1L;    //NOT NEEDED

    @Override
    public List<Job> findAll() {
        // return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        // job.setId(nextId++);     //NOT NEEDED
        // jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        // for (Job job : jobs){
        //     if (job.getId().equals(id)){
        //         return job;
        //     }
        // }
        // return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        // Iterator<Job> iterator = jobs.iterator();
        // while (iterator.hasNext()){
        
        //     Job job = iterator.next();

        //     if(job.getId().equals(id)){
        //         iterator.remove();
        //         return true;
        //     }
        // }
        // return false;
        try {
            jobRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()){
            Job job = jobOptional.get();
            
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;

        // System.out.println(id);
        // System.out.println(updatedJob);
        // for (Job job : jobs){
        //     if (job.getId().equals(id)){
        //         job.setTitle(updatedJob.getTitle());
        //         job.setDescription(updatedJob.getDescription());
        //         job.setMinSalary(updatedJob.getMinSalary());
        //         job.setMaxSalary(updatedJob.getMaxSalary());
        //         job.setLocation(updatedJob.getLocation());
        //         return true;
        //     }
        // }
        // return false; 

    }

}


// VERSION 1 - WITHOUT JPA REPO
// @Service
// public class JobServiceImpl implements JobService {

    // As we dont have a Database we are using a list
//      private List<Job> jobs= new ArrayList();
 
//      private Long nextId = 1L;
 
//      @Override
//      public List<Job> findAll() {
//          return jobs;
//      }
 
//      @Override
//      public void createJob(Job job) {
//          job.setId(nextId++);
//          jobs.add(job);
//      }
 
//      @Override
//      public Job getJobById(Long id) {
 
//          for (Job job : jobs){
//              if (job.getId().equals(id)){
//                  return job;
//              }
//          }
//          return null;
//      }
 
//      @Override
//      public boolean deleteJobById(Long id) {
                 
//          // System.out.println(id);
//          Iterator<Job> iterator = jobs.iterator();
//          while (iterator.hasNext()){
         
//              Job job = iterator.next();
//              // System.out.println(job.getId());
 
//              if(job.getId().equals(id)){
//                  iterator.remove();
//                  return true;
//              }
//          }
//          return false;
//      }
 
//      @Override
//      public boolean updateJobById(Long id, Job updatedJob) {
//          System.out.println(id);
//          System.out.println(updatedJob);
//          for (Job job : jobs){
//              if (job.getId().equals(id)){
//                  job.setTitle(updatedJob.getTitle());
//                  job.setDescription(updatedJob.getDescription());
//                  job.setMinSalary(updatedJob.getMinSalary());
//                  job.setMaxSalary(updatedJob.getMaxSalary());
//                  job.setLocation(updatedJob.getLocation());
//                  return true;
//              }
//          }
//          return false; 
//      }
 
//  }
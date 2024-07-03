package com.recruiter.recruiter.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/jobs")        //Class level
public class JobController {
    // MOVED TO INTERFACE IMPL
    // // As we dont have a Database we are using a list
    // private List<Job> jobs= new ArrayList();

    // THEN ADD SERVICE   //Telusko used @Autowired
    private JobService jobService;
    
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping        //@GetMapping("/jobs")       //Method Level
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());     //RES ENTITY IMPEMENTATION 1
    }

    @PostMapping        //@PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully.", HttpStatus.CREATED);      //RES ENTITY IMPEMENTATION 2

    }

    @GetMapping("/{id}")       //@GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        
        if(job != null){
           return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")            //@DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return ResponseEntity.ok("Job deleted successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")          //@PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        System.out.println(id);
        boolean updated = jobService.updateJobById(id, updatedJob);
        System.out.println(updated);
        if (updated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


// JOB
// GET      /jobs               
// GET      /jobs/{id}:         
// POST     /jobs               
// DELETE   /jobs/{id}:         
// PUT      /jobs/{id}:         
// GET      /jobs/{id}/company: 


// COMPANY
// GET      /companies               
// GET      /companies/{id}:         
// POST     /companies               
// DELETE   /companies/{id}:         
// PUT      /companies/{id}:         

// REVIEW ASSOCIATED WITH COMPANIES
// GET      /companies/{companyId}/reviews               
// GET      /companies/{companyId}/reviews/{reviewId}:         
// POST     /companies/{companyId}/reviews               
// DELETE   /companies/{companyId}/reviews/{reviewId}:         
// PUT      /companies/{companyId}/reviews/{reviewId}: 
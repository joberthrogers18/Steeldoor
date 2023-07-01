package com.steelDoor.controller;

import com.steelDoor.model.Company;
import com.steelDoor.model.Job;
import com.steelDoor.service.CompanyService;
import com.steelDoor.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JobController {
    @Autowired
    JobService jobService;

    @RequestMapping(value = "/job", method= RequestMethod.POST)
    public ResponseEntity<Object> createJob(@RequestBody Job job) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Job jobSaved = jobService.createJob(job);
            map.put("message", "Job create successfully");
            map.put("data", jobSaved);
            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/jobs", method= RequestMethod.GET)
    public ResponseEntity<Object> getAllJobs() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Job> jobs = jobService.getAllJobs();
            map.put("data", jobs);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value ="/job/{idJob}", method= RequestMethod.GET)
    public ResponseEntity<Object> getCompanyById(@PathVariable(value = "idJob") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Optional<Job> job = jobService.getJobById(id);

            if (job.isEmpty()) {
                map.put("message", "Job not found.");
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }

            map.put("data", job);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/job/{idJob}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCompany(@PathVariable(value = "idJob") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            jobService.deleteJob(id);
            map.put("message", "Job deleted successfully");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/job/{idJob}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCompany(@PathVariable(value = "idJob") Long id, @RequestBody Job job) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Job jobUpdated = jobService.updateJob(id, job);
            map.put("data", jobUpdated);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

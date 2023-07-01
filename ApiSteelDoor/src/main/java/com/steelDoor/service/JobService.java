package com.steelDoor.service;

import com.steelDoor.model.Company;
import com.steelDoor.model.Job;
import com.steelDoor.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JobService {

    @Autowired
    JobRepository jobRepository;

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }

    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    public Job updateJob(Long jobId, Job job) {
        Job currentJob = jobRepository.findById(jobId).get();
        currentJob.setCompanyName(job.getCompanyName());
        currentJob.setLocation(job.getLocation());
        currentJob.setTitle(job.getTitle());
        currentJob.setDescription(job.getDescription());
        currentJob.setMinSalary(job.getMinSalary());
        currentJob.setMaxSalary(job.getMaxSalary());
        currentJob.setSkills(job.getSkills());

        return jobRepository.save(currentJob);
    }

}

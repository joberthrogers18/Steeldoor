package com.steelDoor.service;

import com.steelDoor.dto.JobRequest;
import com.steelDoor.dto.SkillRequest;
import com.steelDoor.model.Company;
import com.steelDoor.model.Job;
import com.steelDoor.model.Skill;
import com.steelDoor.model.User;
import com.steelDoor.repository.JobRepository;
import com.steelDoor.repository.SkillRepository;
import com.steelDoor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    UserRepository userRepository;

    public Job createJob(Job job) {
        Job currentJob = new Job();
        currentJob.setCompanyName(job.getCompanyName());
        currentJob.setDescription(job.getDescription());
        currentJob.setLocation(job.getLocation());
        currentJob.setTitle(job.getTitle());
        currentJob.setMinSalary(job.getMinSalary());
        currentJob.setMaxSalary(job.getMaxSalary());

        List<Skill> skills = new ArrayList<>();
        for (Skill dataSkill : job.getSkills()) {
            Skill skill = this.skillRepository.findById(dataSkill.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + dataSkill.getId()));
            skills.add(skill);
        }

        job.setSkills(skills);

        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId).orElseThrow(() -> new EntityNotFoundException("Job not Found"));
    }

    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    public Job updateJob(Long jobId, Job job) {
        Job currentJob = jobRepository.findById(jobId).orElseThrow(
                () -> new EntityNotFoundException("Job not Found")
        );

        currentJob.setCompanyName(job.getCompanyName());
        currentJob.setLocation(job.getLocation());
        currentJob.setTitle(job.getTitle());
        currentJob.setDescription(job.getDescription());
        currentJob.setMinSalary(job.getMinSalary());
        currentJob.setMaxSalary(job.getMaxSalary());

        List<Skill> skills = new ArrayList<>();
        for (Skill dataSkill : job.getSkills()) {
            Skill skill = this.skillRepository.findById(dataSkill.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + dataSkill.getId()));
            skills.add(skill);
        }

        currentJob.setSkills(skills);

        List<User> users = new ArrayList<User>();
        for (User user : job.getUsers()) {
            User userFound = this.userRepository.findById(user.getId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + user.getId()));
            users.add(userFound);
        }

        currentJob.setUsers(users);

        return jobRepository.save(currentJob);
    }

}

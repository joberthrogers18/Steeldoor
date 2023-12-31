package com.steelDoor.service;

import com.steelDoor.dto.RequestLogin;
import com.steelDoor.model.Company;
import com.steelDoor.model.Job;
import com.steelDoor.model.User;
import com.steelDoor.repository.CompanyRepository;
import com.steelDoor.repository.JobRepository;
import com.steelDoor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found"));
    }

    public List<Job> getAppliedJobsUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found"));

        return user.getJobs();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User user) {
        User currentUser = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found"));

        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setBirthday(user.getBirthday());
        currentUser.setPhone(user.getPhone());
        currentUser.setCompany(user.getCompany());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());

        return userRepository.save(currentUser);
    }

    public User verifyIfUserExists(RequestLogin login) {
        User user = userRepository.findByEmailEquals(login.getEmail());

        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }

        if (!Objects.equals(user.getPassword(), login.getPassword())) {
            throw new EntityNotFoundException("Email or password is not the same");
        }

        return user;
    }

}

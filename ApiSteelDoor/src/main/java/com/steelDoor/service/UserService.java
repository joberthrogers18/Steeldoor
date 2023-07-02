package com.steelDoor.service;

import com.steelDoor.model.Job;
import com.steelDoor.model.User;
import com.steelDoor.repository.JobRepository;
import com.steelDoor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

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

        return userRepository.save(currentUser);
    }

}

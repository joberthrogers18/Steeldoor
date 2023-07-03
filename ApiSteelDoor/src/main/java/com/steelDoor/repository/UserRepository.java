package com.steelDoor.repository;

import com.steelDoor.model.Job;
import com.steelDoor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findByEmailEquals(String email);
}

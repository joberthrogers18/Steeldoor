package com.steelDoor.controller;

import com.steelDoor.dto.RequestLogin;
import com.steelDoor.model.Job;
import com.steelDoor.model.Skill;
import com.steelDoor.model.User;
import com.steelDoor.service.SkillService;
import com.steelDoor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method= RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User userCreated = userService.createUser(user);
            map.put("message", "User create successfully");
            map.put("data", userCreated);
            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/users", method= RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<User> users = userService.getAllUsers();
            map.put("data", users);
            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user/{userId}", method= RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable(value = "userId") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User user = userService.getUserById(id);
            map.put("data", user);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());

            if (e instanceof EntityNotFoundException) {
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user/{userId}/jobs", method= RequestMethod.GET)
    public ResponseEntity<Object> getUserJobsApplied(@PathVariable(value = "userId") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Job> jobsUser = userService.getAppliedJobsUser(id);
            map.put("data", jobsUser);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());

            if (e instanceof EntityNotFoundException) {
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user/{userId}", method= RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "userId") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            userService.deleteUser(id);
            map.put("message", "User deleted successfully");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());

            if (e instanceof EntityNotFoundException) {
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user/{userId}", method= RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable(value = "userId") Long id, User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User updatedUser = userService.updateUser(id, user);
            map.put("data", updatedUser);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());

            if (e instanceof EntityNotFoundException) {
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<Object> loginUser(@RequestBody RequestLogin loginData) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User user = userService.verifyIfUserExists(loginData);
            map.put("data", user);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());

            if (e instanceof EntityNotFoundException) {
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

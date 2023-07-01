package com.steelDoor.controller;

import com.steelDoor.model.Job;
import com.steelDoor.model.Skill;
import com.steelDoor.service.JobService;
import com.steelDoor.service.SkillService;
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
public class SkillController {

    @Autowired
    SkillService skillService;

    @RequestMapping(value = "/skill", method= RequestMethod.POST)
    public ResponseEntity<Object> createSkill(@RequestBody Skill skill) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Skill skillSaved = skillService.createSkill(skill);
            map.put("message", "Skill create successfully");
            map.put("data", skillSaved);
            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/skills", method= RequestMethod.GET)
    public ResponseEntity<Object> getAllSkill() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Skill> skills = skillService.getAllSkills();
            map.put("data", skills);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value ="/skill/{idSkill}", method= RequestMethod.GET)
    public ResponseEntity<Object> getSkillById(@PathVariable(value = "idSkill") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Optional<Skill> skill = skillService.getSkillById(id);

            if (skill.isEmpty()) {
                map.put("message", "Skill not found.");
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }

            map.put("data", skill);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/skill/{idSkill}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSkill(@PathVariable(value = "idSkill") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            skillService.deleteSkill(id);
            map.put("message", "Skill deleted successfully");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/skill/{idSkill}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCompany(@PathVariable(value = "idSkill") Long id, @RequestBody Skill skill) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Skill skillUpdated = skillService.updateSkill(id, skill);
            map.put("data", skillUpdated);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

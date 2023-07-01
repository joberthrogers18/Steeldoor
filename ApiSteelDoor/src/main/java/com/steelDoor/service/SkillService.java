package com.steelDoor.service;


import com.steelDoor.model.Skill;
import com.steelDoor.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Optional<Skill> getSkillById(Long skillId) {
        return skillRepository.findById(skillId);
    }

    public void deleteSkill(Long skillId) {
        skillRepository.deleteById(skillId);
    }

    public Skill updateSkill(Long skillId, Skill skill) {
        Skill currentSkill = skillRepository.findById(skillId).get();
        currentSkill.setNameSkill(skill.getNameSkill());
        currentSkill.setJobs(skill.getJobs());

        return skillRepository.save(currentSkill);
    }

}

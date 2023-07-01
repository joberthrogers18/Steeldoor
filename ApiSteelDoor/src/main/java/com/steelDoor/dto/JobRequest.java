package com.steelDoor.dto;

import com.steelDoor.model.Skill;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JobRequest {
    private Long id;
    private String companyName;
    private String location;
    private String title;
    private String description;
    private Double minSalary;
    private Double maxSalary;
    private List<SkillRequest> skills = null;
}

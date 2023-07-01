package com.steelDoor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SkillRequest {
    private Long id;
    private String name;
    private List<JobRequest> jobs = null;
}

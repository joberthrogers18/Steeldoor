package com.steelDoor.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSkill")
    private Long idSkill;

    @Column(name = "nameSkill", nullable = false)
    private String nameSkill;

    @ManyToMany
    @JoinTable(
            name = "jobSkills",
            joinColumns = @JoinColumn(name = "idSkill"),
            inverseJoinColumns = @JoinColumn(name = "idJob"))
    Set<Job> jobs;

    public Long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }


}

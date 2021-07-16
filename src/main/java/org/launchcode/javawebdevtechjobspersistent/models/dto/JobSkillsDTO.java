package org.launchcode.javawebdevtechjobspersistent.models.dto;

import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;

import javax.validation.constraints.NotNull;

public class JobSkillsDTO {

    @NotNull
    private Job job;

    @NotNull
    private Skill skill;

    public JobSkillsDTO() {}

    public Skill getSkill() {
        return skill;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}

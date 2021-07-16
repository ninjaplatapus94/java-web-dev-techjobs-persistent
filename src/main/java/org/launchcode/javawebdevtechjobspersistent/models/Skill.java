package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 300, message = "Description too long")
    @NotBlank(message = "Please enter a description")
    public String description;

    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs  = new ArrayList<>();

    public Skill(String aDescription) {
        this.description = aDescription;
    }

    public Skill() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getJobs() {
        return jobs;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }
 }
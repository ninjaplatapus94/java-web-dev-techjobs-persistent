package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @Size(max =50, message = "Please shorten location.")
    @NotBlank(message = "Please add a location.")
    private String location;

    public Employer(String location) {
        this.location = location;
    }

    public Employer() {         
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs  = new ArrayList<Job>();


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}




package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("title", "My Jobs");

        return "index";
    }
    //TODO addskills and employers as model,addAttributes
    @GetMapping("add")
    public String displayAddJobForm(Model model) {

        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        return "add";
    }
//TODO A user will select an employer when they create a job. Add the employer data from employerRepository into the form template.
// The add job form already includes an employer selection option.
// Be sure your variable name for the employer data matches that already used in templates/add.

// TODO In processAddJobForm, add code inside of this method to select the employer object that has been chosen to be affiliated with the new job.
//  You will need to select the employer using the request parameter you’ve added to the method.

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

//        TODO employer class instead of Optional. set employer and skills for job.

       Employer employer = employerRepository.findById(employerId).orElse(new Employer());
//        Employer employer = employerResult.get();
        model.addAttribute("employer", employer);
        newJob.setEmployer(employer);

        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        model.addAttribute("skills", skillObjs);
        newJob.setSkills(skillObjs);

        jobRepository.save(newJob);

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

            Optional optJob = jobRepository.findById(jobId);
            if (optJob.isPresent()) {
                Job job = (Job) optJob.get();
                model.addAttribute("job", job);
                return "/view";
            } else {
                return "redirect:../";
            }
        }
    }

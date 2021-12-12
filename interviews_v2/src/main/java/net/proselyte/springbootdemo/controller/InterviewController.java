package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.Interview;
import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.service.InterviewService;
import net.proselyte.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class InterviewController {
    private final InterviewService interviewService;

    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("/interviews")
    public String findAll(Model model){
        List<Interview> interviews = interviewService.findAll();
        model.addAttribute("interviews", interviews);
        return "interview-list";
    }

    @GetMapping("/interview-create")
    public String createInterviewForm(Interview interview){
        return "interview-create";
    }

    @PostMapping("/interview-create")
    public String createInterview(Interview interview){
        interviewService.saveInterview(interview);
        return "redirect:/interviews";
    }

    @GetMapping("interview-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        interviewService.deleteById(id);
        return "redirect:/interviews";
    }

    @GetMapping("/interview-update/{id}")
    public String updateInterviewForm(@PathVariable("id") Long id, Model model){
        Interview interview = interviewService.findById(id);
        model.addAttribute("interview", interview);
        return "interview-update";
    }

    @PostMapping("/interview-update")
    public String updateUser(Interview interview){
        interviewService.saveInterview(interview);
        return "redirect:/interviews";
    }
}

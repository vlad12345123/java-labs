package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.Interview;
import net.proselyte.springbootdemo.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    @Autowired
    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public Interview findById(Long id) {
        return interviewRepository.getOne(id);
    }

    public List<Interview> findAll() {
        return interviewRepository.findAll();
    }

    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public void deleteById(Long id) {
        interviewRepository.deleteById(id);
    }
}

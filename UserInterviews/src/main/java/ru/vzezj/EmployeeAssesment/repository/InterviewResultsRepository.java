package ru.vzezj.EmployeeAssesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vzezj.EmployeeAssesment.domain.InterviewResults;

public interface InterviewResultsRepository extends JpaRepository<InterviewResults, Integer> {

}

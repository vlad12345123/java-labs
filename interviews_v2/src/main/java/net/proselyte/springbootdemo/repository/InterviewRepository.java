package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}

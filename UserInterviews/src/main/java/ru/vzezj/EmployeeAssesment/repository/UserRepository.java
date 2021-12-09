package ru.vzezj.EmployeeAssesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vzezj.EmployeeAssesment.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}

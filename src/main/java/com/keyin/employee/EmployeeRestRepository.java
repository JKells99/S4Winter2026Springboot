package com.keyin.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRestRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);
}

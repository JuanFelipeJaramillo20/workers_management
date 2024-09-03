package com.tg1.tg1.Repositories;

import com.tg1.tg1.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}


package com.tg1.tg1.Employee;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.tg1.tg1.Models.Employee;
import com.tg1.tg1.Repositories.EmployeeRepository;
import com.tg1.tg1.Services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeById() {
        Long id = 1L;
        Employee employee = new Employee();
        employee.setId(id);
        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(employeeRepository, times(1)).findById(id);
    }

    @Test
    void testSaveEmployee() {
        Employee employee = new Employee();
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        employeeService.saveEmployee(employee);

        verify(employeeRepository, times(1)).save(employee);
    }
}

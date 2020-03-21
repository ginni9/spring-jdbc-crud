package org.spring.service;

import java.util.List;

import org.spring.dao.UserRepository;
import org.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }


    public void addEmployee(Employee employee) {
        userRepository.save(employee);
    }


    public Employee fetchEmployeeById(int employeeId) {
        return userRepository.getEmpById(employeeId);
    }


    public void deleteEmployeeById(int employeeId) {
        userRepository.deleteEmpById(employeeId);
    }


    public void updateEmployeeById(int newId, String newName, String newDepartment, int employeeId) {
        userRepository.updateEmpById(newId, newName, newDepartment, employeeId);
    }


    public List<Employee> getAllEmployeesInfo() {
        return userRepository.getAllEmp();
    }
}
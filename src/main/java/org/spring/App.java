package org.spring;


import org.spring.service.EmployeeService;
import org.spring.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args )

    {

        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);


        createEmployee(employeeService);
        getEmployeeById(employeeService);
        fetchAllEmployeesInfo(employeeService);
        employeeService.updateEmployeeById(1,"ginni","pto", 1);
        employeeService.deleteEmployeeById(1);


        ctx.close();
    }


    private static void createEmployee(EmployeeService employeeService) {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("gagandeep");
        employee.setDepartment("CS");

        employeeService.addEmployee(employee);
    }

    private static void fetchAllEmployeesInfo(EmployeeService employeeService) {
        List<Employee> empList = employeeService.getAllEmployeesInfo();
        for (Employee employee : empList) {
            System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getDepartment());
        }
    }

    private static void getEmployeeById(EmployeeService employeeService) {
        Employee employee = employeeService.fetchEmployeeById(1);
        System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getDepartment());
    }


    }


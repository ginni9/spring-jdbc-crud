package org.spring.dao;

import java.util.List;
import org.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    public void save (Employee employee) {

        int update=jdbcTemplate.update("INSERT INTO employee(id,name,department) VALUES(?,?,?)", employee.getId(),employee.getName(),employee.getDepartment());
        if(update>0) {
            System.out.println("Success");
            System.out.println(employee);
        }

    }

    public Employee getEmpById(int id) {
        String SQL="SELECT *FROM employee WHERE id=?";
        Employee employee = jdbcTemplate.queryForObject(SQL, new EmployeeRowMapper(), id);
        return employee;
    }


    public void deleteEmpById(int id) {
        String SQL="DELETE FROM employee WHERE id=?";
        int update = jdbcTemplate.update(SQL, id);
        if(update>0)
            System.out.println("success");
    }


    public void updateEmpById(int newID,String newName,String newDept, int id) {
        String SQL="UPDATE employee set id=?,name=?,department=? WHERE id=?";
        int update = jdbcTemplate.update(SQL, newID, newName,newDept,id);
        if(update>0)
            System.out.println("success");

    }


    public List<Employee> getAllEmp() {
        String SQL="SELECT *FROM employee";
        return jdbcTemplate.query(SQL, new EmployeeRowMapper());
    }


}
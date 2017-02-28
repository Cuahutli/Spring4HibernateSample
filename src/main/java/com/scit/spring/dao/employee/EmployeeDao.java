/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.dao;

import java.util.List;
import com.scit.spring.model.Employee;

/**
 *
 * @author cuahutli
 */
public interface EmployeeDao {
    void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    void deleteEmployeeBySsn(String ssn);
    Employee findBySsn(String ssn);
    void updateEmployee(Employee employee);
}

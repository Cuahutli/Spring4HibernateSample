/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.dao.employee;

import com.scit.spring.dao.GenericDAO;
import java.util.List;
import com.scit.spring.model.Employee;

/**
 *
 * @author cuahutli
 */
public interface EmployeeDao extends GenericDAO<Employee, Integer> {
    
    void deleteEmployeeBySsn(String ssn);
    Employee findBySsn(String ssn);
}

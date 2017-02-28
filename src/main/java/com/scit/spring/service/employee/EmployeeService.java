/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.service.employee;

import com.scit.spring.model.Employee;
import com.scit.spring.service.GenericService;


/**
 *
 * @author cuahutli
 */
public interface EmployeeService extends GenericService<Employee, Integer> {
   void deleteEmployeeBySsn(String ssn);
   Employee findBySsn(String ssn);
}

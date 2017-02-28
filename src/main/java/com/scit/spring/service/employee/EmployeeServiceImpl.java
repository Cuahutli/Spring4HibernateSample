/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.service.employee;

import com.scit.spring.dao.GenericDAO;
import com.scit.spring.dao.employee.EmployeeDao;
import com.scit.spring.model.Employee;
import com.scit.spring.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 *
 * @author cuahutli
 */
@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Integer> implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
    
    }
    
    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDaoImpl") GenericDAO<Employee, Integer> dao) {
        super(dao);
        this.employeeDao = (EmployeeDao) dao;
    }
    
    @Override
    public void deleteEmployeeBySsn(String ssn) {
        employeeDao.deleteEmployeeBySsn(ssn);
    }

    @Override
    public Employee findBySsn(String ssn) {
        return employeeDao.findBySsn(ssn);
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.dao;

import java.util.List;

import com.scit.spring.model.Employee;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.scit.spring.model.Employee;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author cuahutli
 */
@Repository("EmployeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao{

    @Override
    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }

    @Override
    public Employee findBySsn(String ssn) {
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }

    @Override
    public void updateEmployee(Employee employee) {
        getSession().update(employee);
    }
    
}

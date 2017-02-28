/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring.dao.employee;


import com.scit.spring.dao.GenericDAOImpl;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.scit.spring.model.Employee;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author cuahutli
 */
@Repository
public class EmployeeDaoImpl extends GenericDAOImpl<Employee, Integer> implements EmployeeDao{


    @Override
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getCurrentSession().createSQLQuery("delete from employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }

    @Override
    public Employee findBySsn(String ssn) {
        Criteria criteria = getCurrentSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }
    
}

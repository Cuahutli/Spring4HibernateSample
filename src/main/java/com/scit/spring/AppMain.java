/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scit.spring;

import com.scit.spring.configuration.AppConfig;
import com.scit.spring.model.Employee;
import com.scit.spring.service.employee.EmployeeService;
import java.math.BigDecimal;
import java.util.List;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author cuahutli
 */
public class AppMain {
    public static void main(String args[]){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String names[] = context.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
        EmployeeService service = (EmployeeService) context.getBean("employeeServiceImpl");
 
        /*
         * Create Employee1
         */
        Employee employee1 = new Employee();
        employee1.setName("Han Yenn");
        employee1.setJoiningDate(new LocalDate(2010, 10, 10));
        employee1.setSalary(new BigDecimal(10000));
        employee1.setSsn("ssn00000001");
 
        /*
         * Create Employee2
         */
        Employee employee2 = new Employee();
        employee2.setName("Dan Thomas");
        employee2.setJoiningDate(new LocalDate(2012, 11, 11));
        employee2.setSalary(new BigDecimal(20000));
        employee2.setSsn("ssn00000002");
 
        /*
         * Persist both Employees
         */
        service.ins(employee1);
        service.ins(employee2);
 
        /*
         * Get all employees list from database
         */
        List<Employee> employees = service.selTodo();
        for (Employee emp : employees) {
            System.out.println(emp);
        }
 
        /*
         * delete an employee
         */
        service.deleteEmployeeBySsn("ssn00000002");
 
        /*
         * update an employee
         */
 
        Employee employee = service.findBySsn("ssn00000001");
        employee.setSalary(new BigDecimal(50000));
        service.upd(employee);
 
        /*
         * Get all employees list from database
         */
        List<Employee> employeeList = service.selTodo();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
 
        context.close();
    }
    
    
}

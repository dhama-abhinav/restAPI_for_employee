package com.example.com.restAPIs;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDao {
    public static List<Employee> employees = new ArrayList<>();
    public static int employeeCount = 5;

    static {
        employees.add(new Employee(111,"Abhinav","delhi"));
        employees.add(new Employee(100, "Abeer", "NewYork"));
        employees.add(new Employee(101, "Sunny", "Delhi"));
        employees.add(new Employee(102, "Denver", "California"));
        employees.add(new Employee(103, "Qazi", "LA"));
    }

    //get all
    public List<Employee> findAll() {
        return employees;
    }

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(++employeeCount);
        }
        employees.add(employee);
        return employee;
    }

    public Employee findOne(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id)
                return emp;
        }
        return null;
    }
    public Employee deleteById(int id) {
        Iterator<Employee> iterator=employees.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return employee;
            }
        }
        return null;
    }

}

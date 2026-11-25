package EmployeeManagment;
import java.util.ArrayList;

import Department.Department;
import FileHandling.*;
import enums.DepartmentType;
import enums.PositionType;
import Employee.*;
import FileHandling.*;
import java.util.ArrayList;
public class EmployeeManager {
    private static EmployeeManager instance;
    private ArrayList<Employee> employees;
    private EmployeeFileHandler fileHandler;

    private EmployeeManager(){
        fileHandler = new EmployeeFileHandler();
        employees = fileHandler.loadEmployees();
    }
    public static EmployeeManager getInstance() {
        if (instance == null) {
            instance = new EmployeeManager();
        }
        return instance;
    }
    public void add(Employee e) {
        employees.add(e);
        fileHandler.saveEmployees(employees);// save after every change
    }

    public void remove(Employee e) {
        employees.remove(e);
        fileHandler.saveEmployees(employees);
    }

    public void save() {
        fileHandler.saveEmployees(employees);// used after an update
    }
    public ArrayList<Employee> getEmployees(){
        return new ArrayList<>(employees);
    }
    public void addFakeEmployees() {
            Department finance = new Department(DepartmentType.FINANCE, 1);
            Department hr = new Department(DepartmentType.HR, 2);
            Department it = new Department(DepartmentType.IT, 3);
            Department marketing = new Department(DepartmentType.MARKETING, 4);

            // Full-time employees
            employees.add(new FulltimeEmployee(
                "Ahmed Hassan", 1001, finance, 25,
                PositionType.JUNIOR, 8000, 1500
            ));

            employees.add(new FulltimeEmployee(
                "Mariam Ali", 1002, hr, 30,
                PositionType.MANAGER, 15000, 3000
            ));

            employees.add(new FulltimeEmployee(
                "Omar Khaled", 1003, it, 27,
                PositionType.SENIOR, 12000, 2000
            ));

            // Part-time employees
            employees.add(new ParttimeEmployee(
                "Nour Mohamed", 1004, marketing, 21,
                PositionType.JUNIOR, 100, 80
            ));

            employees.add(new ParttimeEmployee(
                "Youssef Samir", 1005, it, 23,
                PositionType.SENIOR, 150, 60
            ));

            employees.add(new ParttimeEmployee(
                "Laila Mostafa", 1006, finance, 22,
                PositionType.JUNIOR, 120, 50
            ));

            fileHandler.saveEmployees(employees);
    }
}


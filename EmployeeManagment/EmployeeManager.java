package EmployeeManagment;
import java.util.ArrayList;
import FileHandling.*;

import Employee.*;
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
}


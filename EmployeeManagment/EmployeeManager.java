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
        employees.clear();   // avoids duplicates if this runs more than once

        Department finance   = new Department(DepartmentType.FINANCE, 1);
        Department hr        = new Department(DepartmentType.HR, 2);
        Department it        = new Department(DepartmentType.IT, 3);
        Department marketing = new Department(DepartmentType.MARKETING, 4);
        Department sales     = new Department(DepartmentType.SALES, 5);

        // ---------- IT ----------
        employees.add(new FulltimeEmployee("Omar Khaled",   1003, it, 27, PositionType.SENIOR,  12000, 2000));
        employees.add(new ParttimeEmployee("Youssef Samir", 1005, it, 23, PositionType.SENIOR,  150, 60));
        employees.add(new FulltimeEmployee("Karim Adel",    1007, it, 35, PositionType.MANAGER, 18000, 4000));
        employees.add(new FulltimeEmployee("Salma Nabil",   1008, it, 24, PositionType.JUNIOR,  7000, 800));
        employees.add(new ParttimeEmployee("Hassan Tarek",  1009, it, 20, PositionType.JUNIOR,  90, 70));
        employees.add(new FulltimeEmployee("Dina Farouk",   1010, it, 31, PositionType.SENIOR,  13000, 2500));

        // ---------- HR ----------
        employees.add(new FulltimeEmployee("Mariam Ali",     1002, hr, 30, PositionType.MANAGER, 15000, 3000));
        employees.add(new FulltimeEmployee("Yara Essam",     1011, hr, 26, PositionType.JUNIOR,  6500, 500));
        employees.add(new ParttimeEmployee("Mostafa Gamal",  1012, hr, 28, PositionType.SENIOR,  130, 40));
        employees.add(new FulltimeEmployee("Nada Ibrahim",   1013, hr, 40, PositionType.MANAGER, 17000, 3500));
        employees.add(new ParttimeEmployee("Ali Mahmoud",    1014, hr, 22, PositionType.JUNIOR,  80, 60));
        employees.add(new FulltimeEmployee("Malak Fouad",    1029, hr, 52, PositionType.SENIOR,  14000, 0));   // zero bonus

        // ---------- FINANCE ----------
        employees.add(new FulltimeEmployee("Ahmed Hassan",   1001, finance, 25, PositionType.JUNIOR,  8000, 1500));
        employees.add(new ParttimeEmployee("Laila Mostafa",  1006, finance, 22, PositionType.JUNIOR,  120, 50));
        employees.add(new FulltimeEmployee("Hana Sherif",    1015, finance, 38, PositionType.MANAGER, 20000, 5000));
        employees.add(new FulltimeEmployee("Tamer Wahba",    1016, finance, 29, PositionType.SENIOR,  12500, 2200));
        employees.add(new ParttimeEmployee("Reem Saad",      1017, finance, 25, PositionType.SENIOR,  140, 55));

        // ---------- MARKETING ----------
        employees.add(new ParttimeEmployee("Nour Mohamed",   1004, marketing, 21, PositionType.JUNIOR,  100, 80));
        employees.add(new FulltimeEmployee("Khaled Anwar",   1018, marketing, 33, PositionType.MANAGER, 16000, 3200));
        employees.add(new FulltimeEmployee("Farida Zaki",    1019, marketing, 23, PositionType.JUNIOR,  6800, 600));
        employees.add(new ParttimeEmployee("Adam Fathy",     1020, marketing, 27, PositionType.SENIOR,  135, 45));
        employees.add(new FulltimeEmployee("Mona Hussein",   1021, marketing, 30, PositionType.SENIOR,  11500, 1800));

        // ---------- SALES ----------
        employees.add(new FulltimeEmployee("Ziad Osama",     1022, sales, 36, PositionType.MANAGER, 19000, 6000));
        employees.add(new FulltimeEmployee("Jana Ramy",      1023, sales, 24, PositionType.JUNIOR,  7200, 1200));
        employees.add(new FulltimeEmployee("Bassem Lotfy",   1024, sales, 28, PositionType.SENIOR,  11000, 3000));
        employees.add(new ParttimeEmployee("Heba Magdy",     1025, sales, 26, PositionType.JUNIOR,  95, 65));
        employees.add(new ParttimeEmployee("Seif Amr",       1026, sales, 31, PositionType.SENIOR,  145, 50));
        employees.add(new FulltimeEmployee("Lina Yasser",    1027, sales, 22, PositionType.JUNIOR,  6900, 900));
        employees.add(new ParttimeEmployee("Omar Said",      1028, sales, 45, PositionType.SENIOR,  160, 30));
        employees.add(new ParttimeEmployee("Ramy Nasser",    1030, sales, 19, PositionType.JUNIOR,  85, 0));    // zero hours

        fileHandler.saveEmployees(employees);
    }
}


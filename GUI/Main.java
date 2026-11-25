package GUI;

import java.util.ArrayList;

import Department.Department;
import Employee.Employee;
import Employee.FulltimeEmployee;
import Employee.ParttimeEmployee;
import EmployeeManagment.EmployeeManager;
import enums.DepartmentType;
import enums.PositionType;

public class Main {
    public static void main(String args[]){
        //AddNewEmployee addEmp = new AddNewEmployee();
       // LoginFrame logFrame = new LoginFrame();
       EmployeeManager.getInstance().addFakeEmployees();
       ViewEmployeeFrame view = new ViewEmployeeFrame();
        AddNewEmployee addEmp = new AddNewEmployee();
       // LoginFrame logFrame = new LoginFrame();
       //ViewEmployeeFrame view = new ViewEmployeeFrame();
        //AddNewEmployee addEmp = new AddNewEmployee();
        //LoginFrame logFrame = new LoginFrame();
}
}

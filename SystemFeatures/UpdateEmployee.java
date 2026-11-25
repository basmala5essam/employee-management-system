package SystemFeatures;
import Department.Department;
import EmployeeManagment.*;
import enums.*;
import Employee.*;
import java.util.ArrayList;
public class UpdateEmployee {
    private EmployeeManager manager = EmployeeManager.getInstance();
    private ArrayList<Employee> employees = manager.getEmployees();

    //update employee for full time
    public boolean updateEmployee(int oldId,EmployeeType newType,int newId,String newFullName, Department newDepartment, int newAge, PositionType newPosition, double InitialSalary, double bonus){
        Employee selectedEmployee=null;
        for(Employee e:employees){
            if(e.getEmployeeID()==oldId){
                selectedEmployee = e;
            }
        }
        if(selectedEmployee==null){
            return false;
        }
        if(newType!=selectedEmployee.getEmployeeType()){
            FulltimeEmployee fullSelected = new FulltimeEmployee(newFullName, newId, newDepartment, newAge, newPosition, InitialSalary,bonus);
            employees.remove(selectedEmployee);
            employees.add(fullSelected);
            return true;
        }
        else{
            FulltimeEmployee fullSelected = (FulltimeEmployee) selectedEmployee;
            fullSelected.setEmployeeID(newId);
            fullSelected.setFullName(newFullName);
            fullSelected.setDepartment(newDepartment);
            fullSelected.setPosition(newPosition);
            fullSelected.setInitialSalary(InitialSalary);
            fullSelected.setBonus(bonus);
            fullSelected.setAge(newAge);
            return true;
        }

    }
    //update employee for part time
    public boolean updateEmployee(int oldId,EmployeeType newType,int newId, String newFullName, Department newDepartment, int newAge, PositionType newPosition, double hourlyRate, int hoursWorked){
        Employee selectedEmployee=null;
        for(Employee e:employees){
            if(e.getEmployeeID()==oldId){
                selectedEmployee = e;
            }
        }
        if(selectedEmployee==null){
            return false;
        }
        if(newType!=selectedEmployee.getEmployeeType()){
            ParttimeEmployee partSelected = new ParttimeEmployee(newFullName, newId, newDepartment, newAge, newPosition, hourlyRate,hoursWorked);
            employees.remove(selectedEmployee);
            employees.add(partSelected);
            return true;
        }
        else{
            ParttimeEmployee partSelected = (ParttimeEmployee) selectedEmployee;
            partSelected.setEmployeeID(newId);
            partSelected.setFullName(newFullName);
            partSelected.setDepartment(newDepartment);
            partSelected.setPosition(newPosition);
            partSelected.setHourlyRate(hourlyRate);
            partSelected.setHoursWorked(hoursWorked);
            partSelected.setAge(newAge);
            return true;
        }

    }
}

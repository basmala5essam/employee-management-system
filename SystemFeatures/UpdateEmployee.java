package SystemFeatures;
import Department.Department;
import EmployeeManagment.*;
import enums.*;
import Employee.*;
import java.util.ArrayList;
public class UpdateEmployee {
    private EmployeeManager manager = EmployeeManager.getInstance();
    private ArrayList<Employee> employees = manager.getEmployees();

    public boolean updateEmployee(int oldId,int newId,String newFullName,int newEmployeeID, Department newDepartment, int newAge, PositionType newPosition, double newTotalSalary,String FullName, int EmployeeID, Department department, int age, PositionType position, double InitialSalary, double bonus){
        Employee selectedEmployee;
        for(Employee e:employees){
            if(e.getEmployeeID()==oldId){
                selectedEmployee = e;
            }
        }
        if(selectedEmployee==null){
            return false;
        }
        if(newType==selectedEmployee.getEmployeeType())



    }
}

package SystemFeatures.Search;
import Employee.Employee;
import EmployeeManagment.EmployeeManager;
import java.util.ArrayList;


public class Search 
{
    public Employee searchByID(int EmployeeID)
    {
        for (Employee e : EmployeeManager.getInstance().getEmployees()) 
            if (e.getEmployeeID() == EmployeeID)   return e;
        
        return null;
    }


    public ArrayList<Employee> searchByDepartment(String department)
    {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee e : EmployeeManager.getInstance().getEmployees())
            if (e.getDepartment().getDepartmentName().name().equals(department))
                result.add(e);

        return result;
    }
}
package ValidateEmployee;
import EmployeeManagment.EmployeeManager;
import Employee.*;
import java.util.ArrayList;

public class ValidateEmployee {

    public static boolean validateEmployee(Employee employee) {
        if(employee instanceof FulltimeEmployee){
            FulltimeEmployee fulltimeEmployee = (FulltimeEmployee) employee;
            return validateEmployeeID(fulltimeEmployee.getEmployeeID()) &&
                    validateName(fulltimeEmployee.getFullName()) &&
                    validateAge(fulltimeEmployee.getAge()) &&
                    validateNumericValue(fulltimeEmployee.getInitialSalary()) &&
                    validateNumericValue(fulltimeEmployee.getBonus());
        } else if(employee instanceof ParttimeEmployee){
            ParttimeEmployee parttimeEmployee = (ParttimeEmployee) employee;
            return validateEmployeeID(parttimeEmployee.getEmployeeID()) &&
                    validateName(parttimeEmployee.getFullName()) &&
                    validateAge(parttimeEmployee.getAge()) &&
                    validateNumericValue(parttimeEmployee.getHourlyRate()) &&
                    validateNumericValue(parttimeEmployee.getHoursWorked());
        }
        return false;
    }

    private static boolean validateEmployeeID(int employeeID) {

        // Check if ID is positive
        if (employeeID <= 0) {
            return false;
        }

        // Get all existing employees
        ArrayList<Employee> employees
                = EmployeeManager.getInstance().getEmployees();

        // Check for duplicate ID
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateName(String name) {
        return name != null && name.trim().matches("[a-zA-Z ]+");
    }

    private static boolean validateAge(int age) {
        return age >= 18 && age <= 65;
    }

    private static boolean validateNumericValue(double numericValue) {
        return numericValue >= 0;
    }

    private static boolean validateNumericValue(int numericValue) {
        return numericValue >= 0;
    }
    public static boolean validateFulltimeUpdate(int oldId, int newId, String name, int age,double initialSalary, double bonus) {
    return validateIDForUpdate(newId, oldId) &&
           validateName(name) &&
           validateAge(age) &&
           validateNumericValue(initialSalary) &&
           validateNumericValue(bonus);
    }

    public static boolean validateParttimeUpdate(int oldId, int newId, String name, int age, double hourlyRate, int hoursWorked) {
        return validateIDForUpdate(newId, oldId) &&
            validateName(name) &&
            validateAge(age) &&
            validateNumericValue(hourlyRate) &&
            validateNumericValue(hoursWorked);
    }

    private static boolean validateIDForUpdate(int newId, int oldId) {
        if (newId <= 0) return false;
        if (newId == oldId) return true; // ID not changed, so not a duplicate
        return validateEmployeeID(newId);  // changed, so it must be unique
    }
}

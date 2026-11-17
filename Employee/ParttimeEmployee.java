package Employee;
import Department.Department;
import enums.PositionType;

public class ParttimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public ParttimeEmployee(String FullName, int EmployeeID, Department department, int age, PositionType position, double hourlyRate, int hoursWorked) {
        super(FullName, EmployeeID, department, age, position, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.TotalSalary = calculateTotalSalary();
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double calculateTotalSalary() {
        return hourlyRate * hoursWorked;
    }


    @Override
    public String toString() {
        return "ParttimeEmployee{" +
                "FullName='" + getFullName() + '\'' +
                ", EmployeeID=" + getEmployeeID() +
                ", department='" + getDepartment() + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}
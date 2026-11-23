package Employee;
import Department.Department;
import enums.PositionType;

public class FulltimeEmployee extends Employee {
    private double InitialSalary;
    private double bonus;

    public FulltimeEmployee(String FullName, int EmployeeID, Department department, int age, PositionType position, double InitialSalary, double bonus) {
        super(FullName, EmployeeID, department, age, position, 0);
        this.InitialSalary = InitialSalary;
        this.bonus = bonus;
        this.TotalSalary = calculateTotalSalary();
        
    }
    
    public double getBonus() {
        return bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return InitialSalary + bonus;
    }


    @Override
    public String toString() {
        return "FulltimeEmployee{" +
                "FullName='" + getFullName() + '\'' +
                ", EmployeeID=" + getEmployeeID() +
                ", department='" + getDepartment() + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    @Override
    public String toCsvLine() {return "Full-time," + baseCsv() + "," + InitialSalary + "," + bonus;}
}
package Employee;
import Department.Department;
import enums.PositionType;

public abstract class Employee {
    protected int EmployeeID;
    protected  String FullName;
    protected Department department;
    protected int age;
    protected PositionType position;
    protected double TotalSalary;

    public Employee(String FullName, int EmployeeID, Department department, int age, PositionType position, double TotalSalary) {
        this.FullName = FullName;
        this.EmployeeID = EmployeeID;
        this.department = department;
        this.age = age;
        this.position = position;
        this.TotalSalary = TotalSalary;
    }

    public String getFullName() {
        return FullName;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public Department getDepartment() {
        return department;
    }

    public abstract double calculateTotalSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "FullName='" + FullName + '\'' +
                ", EmployeeID=" + EmployeeID +
                ", department=" + department + ',' +
                '}';
    }
}
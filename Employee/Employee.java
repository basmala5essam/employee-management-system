package Employee;
import Department.Department;
import enums.EmployeeType;
import enums.PositionType;

public abstract class Employee {
    protected int EmployeeID;
    protected  String FullName;
    protected Department department;
    protected int age;
    protected PositionType position;
    protected EmployeeType type;
    protected double TotalSalary;

    public Employee(String FullName, int EmployeeID, Department department, int age, PositionType position,EmployeeType type, double TotalSalary) {
        this.FullName = FullName;
        this.EmployeeID = EmployeeID;
        this.department = department;
        this.age = age;
        this.position = position;
        this.type = type;
        this.TotalSalary = TotalSalary;
    }

    public String getFullName() {
        return FullName;
    }
    public void setFullName(String name){
        this.FullName = name;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }
    public void setEmployeeID(int id){
        EmployeeID = id;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department newDepartment){
        department = newDepartment;
    }
    public PositionType getPosition(){
        return position;
    }
    public void setPosition(PositionType newPosition){
        position = newPosition;
    }
    public EmployeeType getEmployeeType(){
        return type;
    }
    public void setEmployeeType(EmployeeType newType){
        type = newType;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int newAge){
        age = newAge;
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
    protected String baseCsv() {return EmployeeID + "," + FullName + "," + age + "," + department.getDepartmentName() + "," + position;}
    public abstract String toCsvLine();
}
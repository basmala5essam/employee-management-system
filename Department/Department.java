package Department;
import enums.DepartmentType;

public class Department {
    private DepartmentType departmentName;
    private int departmentID;

    public Department(DepartmentType departmentName, int departmentID) {
        this.departmentName = departmentName;
        this.departmentID = departmentID;
    }

    public DepartmentType getDepartmentName() {
        return departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", departmentID=" + departmentID +
                '}';
    }
}
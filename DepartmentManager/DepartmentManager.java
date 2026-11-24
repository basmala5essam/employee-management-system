package DepartmentManager;
import Department.Department;
import enums.DepartmentType;
import java.util.ArrayList;

public class DepartmentManager {
    private final ArrayList<Department> departments = new ArrayList<>();

    // one Department object per DepartmentType (HR, IT, ...)
    public DepartmentManager() {
        for (DepartmentType type : DepartmentType.values()) {
            departments.add(new Department(type, type.ordinal() + 1));
        }
    }

    public Department findByName(String name) {
        for (Department d : departments) {
            if (d.getDepartmentName().name().equalsIgnoreCase(name.trim())) {
                return d;
            }
        }
        return null;
    }
}
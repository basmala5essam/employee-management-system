package Department;
import enums.DepartmentType;

public class HR extends Department {
    private static HR instance;

    private HR() {
        super(DepartmentType.HR, 1011);
    }
    
    public static HR getInstance() {
        if (instance == null) {
            instance = new HR();
        }
        return instance;
    }
}
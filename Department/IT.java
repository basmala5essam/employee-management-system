package Department;
import enums.DepartmentType;

public class IT extends Department {
    private static IT instance;

    private IT() {
        super(DepartmentType.IT, 1012);
    }
    
    public static IT getInstance() {
        if (instance == null) {
            instance = new IT();
        }
        return instance;
    }
}
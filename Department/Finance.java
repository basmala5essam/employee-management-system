package Department;
import enums.DepartmentType;

public class Finance extends Department {
    private static Finance instance;

    private Finance() {
        super(DepartmentType.FINANCE, 1013);
    }
    
    public static Finance getInstance() {
        if (instance == null) {
            instance = new Finance();
        }
        return instance;
    }
}
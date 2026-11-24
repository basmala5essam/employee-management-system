package Department;
import enums.DepartmentType;

public class Marketing extends Department {
    private static Marketing instance;

    private Marketing() {
        super(DepartmentType.MARKETING, 1014);
    }
    
    public static Marketing getInstance() {
        if (instance == null) {
            instance = new Marketing();
        }
        return instance;
    }
}
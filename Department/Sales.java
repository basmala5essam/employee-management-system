package Department;
import enums.DepartmentType;

public class Sales extends Department {
    private static Sales instance;

    private Sales() {
        super(DepartmentType.SALES, 1015);
    }

    public static Sales getInstance() {
        if (instance == null) {
            instance = new Sales();
        }
        return instance;
    }
}
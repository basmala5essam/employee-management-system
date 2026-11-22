package FileHandling;
import java.io.File;
import java.util.ArrayList;
import Employee.*;
public class EmployeeFileHandler {

    private static final String FILE_NAME = "employees.csv";
    private final File file = new File(FILE_NAME);

    /*note: for the csv file to be used, don't create it by hand.
     saveEmployees creates it automatically the first time it runs, 
     and loadEmployees just checks file.exists() and returns an empty list */
    
    public ArrayList<Employee> loadEmployees() {
        //logic to read from the file and return an array list.
        return new ArrayList<>();   
    }
    /*NOTE: what loadEmployees does:
    loadEmployees(): file to objects:
    - Reads the file and rebuilds your FulltimeEmployee and ParttimeEmployee objects from the text in it.
    - Returns them as an ArrayList<Employee>.
    - Called once, when the app starts (in the manager's constructor).
    - If the file doesn't exist yet (first launch), it returns an empty list. */
    
    public void saveEmployees(ArrayList<Employee> employees) {
        //logic that writes to the file
    }
    /*
    saveEmployees(list): objects to file
    Takes the current list and writes one line per employee to the file, replacing whatever was there before.
    Called after every change: add, update, delete. */
    
}

package FileHandling;
import Employee.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeFileHandler 
{

    private static final String FILE_NAME = "employee.csv";   // file's relative path
    private final File file = new File(FILE_NAME);

    // helper function to 
    
    // read from file and return array list
    public ArrayList<Employee> loadEmployees() 
    {
        ArrayList<Employee> employees = new ArrayList<>();
        if (!file.exists()) return employees;

        try (Scanner myReader = new Scanner(file)) 
        {
            while (myReader.hasNextLine()) 
            {
                String line = myReader.nextLine();
                if (line.isBlank()) continue;
                try 
                {
                    employees.add(parseLine(line));
                }   catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex){}            
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Cannot read from file");
            e.printStackTrace();
        }

        return employees;   
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

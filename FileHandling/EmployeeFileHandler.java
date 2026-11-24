package FileHandling;
import Department.Department;
import DepartmentManager.DepartmentManager;
import Employee.*;
import enums.PositionType;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeFileHandler 
{

    private static final String FILE_NAME = "employee.csv";   // file's relative path
    private final File file = new File(FILE_NAME);
    private final DepartmentManager departmentManager = new DepartmentManager();


    // helper function to load the csv file line by line
    private Employee parseLine(String line)
    {
        String[] p = line.split(",");
        int EmployeeID = Integer.parseInt(p[1]);
        String FullName = p[2];
        int age = Integer.parseInt(p[3]);
        Department dep = departmentManager.findByName(p[4]);
        PositionType position = PositionType.valueOf(p[5]);
        double s1 = Double.parseDouble(p[6]);
        double s2 = Double.parseDouble(p[7]);
        switch (p[0]) {
            case "Full-time":
                return new FulltimeEmployee(FullName, EmployeeID, dep, age, position, s1, s2);                

            case "Part-time":
                return new ParttimeEmployee(FullName, EmployeeID, dep, age, position, s1, (int)s2);
                
            default:
                throw new IllegalArgumentException("Unknown type: " + p[0]);
        }

    }
    
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
    
    public void saveEmployees(ArrayList<Employee> employees)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file)))
        {
            for (Employee e : employees)
                writer.println(e.toCsvLine());
        }
        catch (IOException e)
        {
            System.out.println("Cannot write to file");
            e.printStackTrace();
        }
    }
    /*
    saveEmployees(list): objects to file
    Takes the current list and writes one line per employee to the file, replacing whatever was there before.
    Called after every change: add, update, delete. */
    
}

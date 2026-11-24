package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Department.Department;
import Employee.*;
import enums.DepartmentType;
import enums.PositionType;

import java.util.ArrayList;
import java.awt.*;

public class ViewEmployeeFrame extends JFrame {
    private JButton searchButton, showButton, deleteButton, updateButton;
    private JComboBox<String> departmentBox;
    private JLabel searchLabel,departmentLabel;
    private JTextField searchField;
    private JTable infoTable;
    private DefaultTableModel tableModel;
    private JPanel topPanel, centerPanel, bottomPanel;
    private JScrollPane tableScroll;
    public ViewEmployeeFrame(){
        this.setSize(800,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(300,20);

        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        this.setLayout(null);
        topPanel.setLayout(null);
        centerPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBounds(0,0,800,100);
        centerPanel.setBounds(0,100,800,400);
        bottomPanel.setBounds(0,500,800,150);
        topPanel.setBackground(Color.pink);
        centerPanel.setBackground(Color.lightGray);
        bottomPanel.setBackground(Color.pink);

        //create buttons:
        searchButton = new JButton(" Search ");
        showButton = new JButton(" Show ");
        deleteButton = new JButton(" Delete ");
        updateButton = new JButton(" Update ");

        //create department jcombobox 
        departmentBox = new JComboBox<>(new String[]{"All", "IT", "Human Resources", "Finance", "Marketing", "Sales"});
        //create model that jtable will use to hold data in rows:
        String[] columns = {"ID", "Name", "Age", "Department", "Position", "Type", "Salary"};
        tableModel = new DefaultTableModel(columns,0){
                @Override
                public boolean isCellEditable(int row, int col) {
                    return false;  //so rows cant be edited just by writing in the cells
            }
        }; 
        //create jtable and scroll
        infoTable = new JTable(tableModel);
        infoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        infoTable.setRowHeight(25);
        tableScroll = new JScrollPane(infoTable);
        
        //create JLabels:
        searchLabel = new JLabel(" Search by ID or Name ");
        departmentLabel = new JLabel(" Department ");

        //create search text field:
        searchField = new JTextField();

        // set bounds and add components in top panel:
        searchLabel.setBounds(10,10,175,25);
        searchLabel.setFont(new Font("Arial",Font.BOLD,16));

        searchField.setBounds(185,10,150,25);
        searchField.setFont(new Font("Arial",Font.BOLD,14));

        searchButton.setBounds(185,55,100,25);

        departmentLabel.setBounds(430,10,100,25);
        departmentLabel.setFont(new Font("Arial",Font.BOLD,16));

        departmentBox.setBounds(540,10,150,25);
        departmentBox.setFont(new Font("Arial",Font.BOLD,14));

        showButton.setBounds(540,55,100,25);

    
        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(departmentBox);
        topPanel.add(departmentLabel);
        topPanel.add(showButton);

        //set bounds and add components in center panel:
        tableScroll.setBounds(10, 10, 770, 380);
        centerPanel.add(tableScroll);
        
        //testing with fake data
        Department fakeDep1 = new Department(DepartmentType.FINANCE, 1);
        Department fakeDep2 = new Department(DepartmentType.HR, 2);
        Employee testEmployee1 = new FulltimeEmployee("Shery Ihab",10191,fakeDep1,19,PositionType.JUNIOR,1000,2000);
        Employee testEmployee2 = new ParttimeEmployee("Shiko Ihab",1,fakeDep1,2,PositionType.MANAGER,100,10);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(testEmployee1);
        employees.add(testEmployee2);
        refreshTable(employees);

        //set bounds and add components in bottom panel:
        deleteButton.setBounds(200,30,150,35);
        deleteButton.setFont(new Font("Arial",Font.BOLD,14));
        updateButton.setBounds(400,30,150,35);
        updateButton.setFont(new Font("Arial",Font.BOLD,14));

        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);
        add(topPanel);
        add(centerPanel);
        add(bottomPanel);
        this.setVisible(true);
    }
    public void refreshTable(ArrayList<Employee> employees) {
        tableModel.setRowCount(0);   // clear
        for (Employee e : employees) {
            tableModel.addRow(new Object[]{
                e.getEmployeeID(), e.getFullName(), e.getAge(), e.getDepartment(),
                e.getPosition(), e.getEmployeeType(), e.calculateTotalSalary()   // getSalary() is polymorphic
            });
        }
    }
}

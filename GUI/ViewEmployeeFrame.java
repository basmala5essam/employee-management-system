package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Department.Department;
import Employee.*;
import enums.DepartmentType;
import enums.EmployeeType;
import enums.PositionType;
import DepartmentManager.DepartmentManager;
import java.util.ArrayList;
import EmployeeManagment.*;

import SystemFeatures.*;
import SystemFeatures.Search.*;
import java.util.ArrayList;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmployeeFrame extends JFrame {
    private JButton searchButton, deleteButton, updateButton,addNewEmployeeButton;
    private JComboBox<String> departmentBox;
    private JLabel searchLabel,departmentLabel;
    private JTextField searchField;
    private JTable infoTable;
    private DefaultTableModel tableModel;
    private JPanel topPanel, centerPanel, bottomPanel;
    private JScrollPane tableScroll;
    private EmployeeManager employeeManager = EmployeeManager.getInstance();
    private DepartmentManager departmentManager = new DepartmentManager();
    private ArrayList<Employee> employees = employeeManager.getEmployees();
    private Listener listener = new Listener();
    private DepartmentFilterListener deptFilterListener = new DepartmentFilterListener();

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
        deleteButton = new JButton(" Delete ");
        updateButton = new JButton(" Update ");
        addNewEmployeeButton = new JButton(" Add New Employee ");

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
        searchLabel = new JLabel(" Search by ID ");
        departmentLabel = new JLabel(" Department ");

        //create search text field:
        searchField = new JTextField();

        // set bounds and add components in top panel:
        searchLabel.setBounds(10,10,110,25);
        searchLabel.setFont(new Font("Arial",Font.BOLD,16));

        searchField.setBounds(125,10,150,25);
        searchField.setFont(new Font("Arial",Font.BOLD,14));

        searchButton.setBounds(125,55,100,25);

        departmentLabel.setBounds(430,10,100,25);
        departmentLabel.setFont(new Font("Arial",Font.BOLD,16));

        departmentBox.setBounds(540,10,150,25);
        departmentBox.setFont(new Font("Arial",Font.BOLD,14));
    
        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(departmentBox);
        topPanel.add(departmentLabel);

        //set bounds and add components in center panel:
        tableScroll.setBounds(10, 10, 770, 380);
        centerPanel.add(tableScroll);
        

        //set bounds and add components in bottom panel:
        deleteButton.setBounds(350,30,150,35);
        deleteButton.setFont(new Font("Arial",Font.BOLD,14));
        updateButton.setBounds(550,30,150,35);
        updateButton.setFont(new Font("Arial",Font.BOLD,14));
        addNewEmployeeButton.setBounds(30,30,200,35);
        
        refreshTable();
        //adding actions:
        updateButton.addActionListener(listener);
        departmentBox.addActionListener(deptFilterListener);
        deleteButton.addActionListener(listener);
        searchButton.addActionListener(listener);
        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);
        bottomPanel.add(addNewEmployeeButton);

        add(topPanel);
        add(centerPanel);
        add(bottomPanel);
        this.setVisible(true);
    }
    //used when all is selected
    private void refreshTable() {
        employees = employeeManager.getEmployees();
        tableModel.setRowCount(0);   // clear
        for (Employee e : employees) {
            tableModel.addRow(new Object[]{
                e.getEmployeeID(), e.getFullName(), e.getAge(), e.getDepartment().getDepartmentName(),
                e.getPosition(), e.getEmployeeType(), e.calculateTotalSalary()   // getSalary() is polymorphic
            });
        }
    }
    //used for department filtering
    private void refreshTable(ArrayList<Employee> selectedEmployees) {
        tableModel.setRowCount(0);   // clear
        for (Employee e : selectedEmployees) {
            tableModel.addRow(new Object[]{
                e.getEmployeeID(), e.getFullName(), e.getAge(), e.getDepartment().getDepartmentName(),
                e.getPosition(), e.getEmployeeType(), e.calculateTotalSalary()   // getSalary() is polymorphic
            });
        }
    }
    //used for searching by id
    private void refreshTable(Employee e) {
        tableModel.setRowCount(0); //clear
        tableModel.addRow(new Object[]{e.getEmployeeID(), e.getFullName(), e.getAge(), e.getDepartment().getDepartmentName(),
                e.getPosition(), e.getEmployeeType(), e.calculateTotalSalary()});
        }
    //used for searching by id + filtering by department
    private void refreshTable(ArrayList<Employee> selectedEmployees,Employee e){
        if(selectedEmployees.contains(e)){
            refreshTable(e);
        }
        else{
            tableModel.setRowCount(0); //clear as no intersection found
        }

    }
    private ArrayList<Employee> filterByDepartment(){
        String dept = (String) departmentBox.getSelectedItem();
        Search searchByDept = new Search();
        if(dept.equals("All")){
            return employeeManager.getEmployees();
        }
        ArrayList<Employee> filtered;
        //"All", "IT", "Human Resources", "Finance", "Marketing", "Sales"
        switch(dept){
            case "IT":
                filtered = searchByDept.searchByDepartment(DepartmentType.IT.name());
                break;
            case "Human Resources":
                filtered = searchByDept.searchByDepartment(DepartmentType.HR.name());
                break;
            case "Finance":
                filtered = searchByDept.searchByDepartment(DepartmentType.FINANCE.name());
                break;
            case "Marketing":
                filtered = searchByDept.searchByDepartment(DepartmentType.MARKETING.name());
                break;
            case "Sales":
                filtered = searchByDept.searchByDepartment(DepartmentType.SALES.name());
                break;
            default:
                return null;
        }
        return filtered;
    }
    private void showUpdateDialogFulltime(Employee employee,int oldId) {
        FulltimeEmployee fulltimeEmployee = (FulltimeEmployee) employee;
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 10));
        JTextField nameField = new JTextField(fulltimeEmployee.getFullName());
        JTextField idField = new JTextField(String.valueOf(fulltimeEmployee.getEmployeeID()));
        JTextField ageField = new JTextField(String.valueOf(fulltimeEmployee.getAge()));
        JTextField initialSalaryField = new JTextField(String.valueOf(fulltimeEmployee.getInitialSalary()));
        JTextField bonusField = new JTextField(String.valueOf(fulltimeEmployee.getBonus()));
        JComboBox<DepartmentType> departmentBox = new JComboBox<>(DepartmentType.values());
        JComboBox<PositionType> positionBox = new JComboBox<>(PositionType.values());
        JComboBox<EmployeeType> employeeTypeBox = new JComboBox<>(EmployeeType.values());

        departmentBox.setSelectedItem(fulltimeEmployee.getDepartment().getDepartmentName()); 
        positionBox.setSelectedItem(fulltimeEmployee.getPosition());                         
        employeeTypeBox.setSelectedItem(EmployeeType.FULL_TIME);                             
        employeeTypeBox.addActionListener(new TypeListener(panel, nameField, idField, ageField,
                departmentBox, positionBox, employeeTypeBox, EmployeeType.FULL_TIME, oldId)); 


        panel.add(new JLabel("Full Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Employee Type:"));
        panel.add(employeeTypeBox);

        panel.add(new JLabel("ID:"));
        panel.add(idField);

        panel.add(new JLabel("Age:"));
        panel.add(ageField);

        panel.add(new JLabel("Department:"));
        panel.add(departmentBox);

        panel.add(new JLabel("Position:"));
        panel.add(positionBox);

        panel.add(new JLabel("Initial Salary:"));
        panel.add(initialSalaryField);

        panel.add(new JLabel("Bonus:"));
        panel.add(bonusField);

        int result = JOptionPane.showConfirmDialog(
            this,
            panel,
            "Update Employee",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            UpdateEmployee updateEmp = new UpdateEmployee();
            int newId = Integer.parseInt(idField.getText());
            String newFullName = nameField.getText();
            
            int newAge = Integer.parseInt(ageField.getText());
            PositionType newPosition = (PositionType) positionBox.getSelectedItem();
            double InitialSalary = Double.parseDouble(initialSalaryField.getText());
            double bonus = Double.parseDouble(bonusField.getText());
            Department newDepartment = departmentManager.findByName(((DepartmentType) departmentBox.getSelectedItem()).name()); 
            updateEmp.updateEmployee(oldId,EmployeeType.FULL_TIME,newId,newFullName,newDepartment,newAge,newPosition,InitialSalary,bonus);
        }
    }
    private void showUpdateDialogParttime(Employee employee, int oldId) {
        ParttimeEmployee parttimeEmployee = (ParttimeEmployee) employee;
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 10));
        JTextField nameField = new JTextField(parttimeEmployee.getFullName());
        JTextField idField = new JTextField(String.valueOf(parttimeEmployee.getEmployeeID()));
        JTextField ageField = new JTextField(String.valueOf(parttimeEmployee.getAge()));
        JTextField hourlyRateField = new JTextField(String.valueOf(parttimeEmployee.getHourlyRate()));
        JTextField hoursField = new JTextField(String.valueOf(parttimeEmployee.getHoursWorked()));
        JComboBox<DepartmentType> departmentBox = new JComboBox<>(DepartmentType.values());
        JComboBox<PositionType> positionBox = new JComboBox<>(PositionType.values());
        JComboBox<EmployeeType> employeeTypeBox = new JComboBox<>(EmployeeType.values());

        departmentBox.setSelectedItem(parttimeEmployee.getDepartment().getDepartmentName());
        positionBox.setSelectedItem(parttimeEmployee.getPosition());
        employeeTypeBox.setSelectedItem(EmployeeType.PART_TIME);
        employeeTypeBox.addActionListener(new TypeListener(panel, nameField, idField, ageField,
                departmentBox, positionBox, employeeTypeBox, EmployeeType.PART_TIME, oldId));

        panel.add(new JLabel("Full Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Employee Type:"));
        panel.add(employeeTypeBox);

        panel.add(new JLabel("ID:"));
        panel.add(idField);

        panel.add(new JLabel("Age:"));
        panel.add(ageField);

        panel.add(new JLabel("Department:"));
        panel.add(departmentBox);

        panel.add(new JLabel("Position:"));
        panel.add(positionBox);

        panel.add(new JLabel("Hourly Rate:"));
        panel.add(hourlyRateField);

        panel.add(new JLabel("Hours Worked:"));
        panel.add(hoursField);

        int result = JOptionPane.showConfirmDialog(
            this, panel, "Update Employee",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            UpdateEmployee updateEmp = new UpdateEmployee();
            int newId = Integer.parseInt(idField.getText());
            String newFullName = nameField.getText();
            Department newDepartment = departmentManager.findByName(((DepartmentType) departmentBox.getSelectedItem()).name());
            int newAge = Integer.parseInt(ageField.getText());
            PositionType newPosition = (PositionType) positionBox.getSelectedItem();
            double hourlyRate = Double.parseDouble(hourlyRateField.getText());
            int hoursWorked = Integer.parseInt(hoursField.getText());

            updateEmp.updateEmployee(oldId, EmployeeType.PART_TIME, newId, newFullName, newDepartment, newAge, newPosition, hourlyRate, hoursWorked);
    }
}
    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == updateButton || e.getSource()==deleteButton) {
                int selectedRow = infoTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(ViewEmployeeFrame.this,"Please select an employee first!");
                    return;
                }
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                Employee selectedEmployee = null;
                for (Employee emp : employees) {

                    if (emp.getEmployeeID() == id) {
                        selectedEmployee = emp;
                        break;
                    }
                }
                if(e.getSource()==updateButton){
                    if (selectedEmployee instanceof FulltimeEmployee) {
                        showUpdateDialogFulltime(selectedEmployee, selectedEmployee.getEmployeeID());
                    } else {
                        showUpdateDialogParttime(selectedEmployee, selectedEmployee.getEmployeeID());
                    }
                    refreshTable();
                }
                if(e.getSource()==deleteButton){
                    employeeManager.remove(selectedEmployee);
                    refreshTable();
                }
            }
            if(e.getSource()==searchButton){
                try{
                    int idRequired = Integer.parseInt(searchField.getText().trim());
                    Search searchId = new Search();
                    String dept = (String) departmentBox.getSelectedItem();
                    if(!dept.equals("All")){ //some department is selected
                        refreshTable(filterByDepartment(),searchId.searchByID(idRequired));
                    }
                    else{
                        refreshTable(searchId.searchByID(idRequired));
                    }
                    searchField.setText("");
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(ViewEmployeeFrame.this, "ID must be a number.");
                }
            }
            
        }
    }
    private class TypeListener implements ActionListener {
            private JPanel panel;
            private JTextField nameField, idField, ageField;
            private JComboBox<DepartmentType> departmentBox;
            private JComboBox<PositionType> positionBox;
            private JComboBox<EmployeeType> typeBox;
            private EmployeeType currentType;
            private int oldId;

            TypeListener(JPanel panel, JTextField nameField, JTextField idField, JTextField ageField,
                        JComboBox<DepartmentType> departmentBox, JComboBox<PositionType> positionBox,
                        JComboBox<EmployeeType> typeBox, EmployeeType currentType, int oldId) {
                this.panel = panel;
                this.nameField = nameField;
                this.idField = idField;
                this.ageField = ageField;
                this.departmentBox = departmentBox;
                this.positionBox = positionBox;
                this.typeBox = typeBox;
                this.currentType = currentType;
                this.oldId = oldId;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeType newType = (EmployeeType) typeBox.getSelectedItem();
                if (newType == currentType) return;   // same type picked, do nothing

                try {
                    int id = Integer.parseInt(idField.getText());
                    int age = Integer.parseInt(ageField.getText());
                    Department dept = departmentManager.findByName(((DepartmentType) departmentBox.getSelectedItem()).name());
                    PositionType pos = (PositionType) positionBox.getSelectedItem();
                    String name = nameField.getText();

                    SwingUtilities.getWindowAncestor(panel).dispose();   // close current dialog

                    if (newType == EmployeeType.PART_TIME) {
                        showUpdateDialogParttime(new ParttimeEmployee(name, id, dept, age, pos, 0, 0), oldId);
                    } else {
                        showUpdateDialogFulltime(new FulltimeEmployee(name, id, dept, age, pos, 0, 0), oldId);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid ID and age first.");
                    typeBox.setSelectedItem(currentType);
                }
            }
        }
        private class DepartmentFilterListener implements ActionListener{
            @Override 
            public void actionPerformed(ActionEvent e){
                String dept = (String) departmentBox.getSelectedItem();
                if(dept.equals("All")){
                    refreshTable();
                    return;
                }
                ArrayList<Employee> filtered = filterByDepartment();
                refreshTable(filtered);
            }
}
}

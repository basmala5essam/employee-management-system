package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Employee.*;
import Department.*;
import enums.*;
import ValidateEmployee.*;
import EmployeeManagment.*;

public class AddNewEmployee extends JFrame {

    private JLabel employeeIdLabel, fullnameLabel, ageLabel, departmentLabel, positionLabel, employeeTypeLabel, initialSalaryLabel, bonusLabel, hoursLabel, hourlyRateLabel;
    private JTextField employeeIdField, fullnameField, ageField, initialSalaryField, bonusField, hoursField, hourlyRateField;
    private JComboBox<String> departmentComboBox, positionComboBox, employeeTypeComboBox;
    private JButton addButton, cancelButton;
    private JPanel panel;
    private Listener listener;

    public AddNewEmployee() {
        setTitle("Add New Employee");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(300, 100);

        // Create labels
        employeeIdLabel = new JLabel("Employee ID:");
        fullnameLabel = new JLabel("Full Name:");
        ageLabel = new JLabel("Age:");
        departmentLabel = new JLabel("Department:");
        positionLabel = new JLabel("Position:");
        employeeTypeLabel = new JLabel("Employee Type:");
        initialSalaryLabel = new JLabel("Basic Salary:");
        bonusLabel = new JLabel("Bonus:");
        hoursLabel = new JLabel("Total Hours Worked:");
        hourlyRateLabel = new JLabel("Hourly Rate:");

        // Create text fields
        employeeIdField = new JTextField();
        fullnameField = new JTextField();
        ageField = new JTextField();
        initialSalaryField = new JTextField();
        bonusField = new JTextField();
        hoursField = new JTextField();
        hourlyRateField = new JTextField();

        // Create combo boxes
        departmentComboBox = new JComboBox<>(new String[]{"HR", "IT", "FINANCE", "MARKETING", "SALES"});
        positionComboBox = new JComboBox<>(new String[]{"INTERN", "JUNIOR", "SENIOR", "MANAGER", "DIRECTOR"});
        employeeTypeComboBox = new JComboBox<>(new String[]{"FULL TIME", "PART TIME"});

        // Create buttons
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        listener = new Listener();
        addButton.addActionListener(listener);
        cancelButton.addActionListener(listener);

        // Create panel and add components
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(employeeIdLabel);
        panel.add(employeeIdField);
        panel.add(fullnameLabel);
        panel.add(fullnameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(departmentLabel);
        panel.add(departmentComboBox);
        panel.add(positionLabel);
        panel.add(positionComboBox);
        panel.add(employeeTypeLabel);
        panel.add(employeeTypeComboBox);
        panel.add(initialSalaryLabel);
        panel.add(initialSalaryField);
        panel.add(bonusLabel);
        panel.add(bonusField);
        panel.add(hoursLabel);
        panel.add(hoursField);
        panel.add(hourlyRateLabel);
        panel.add(hourlyRateField);
        panel.add(addButton);
        panel.add(cancelButton);
        panel.setBackground(Color.pink);

        // Set bounds for components
        employeeIdLabel.setBounds(125, 20, 150, 25);
        employeeIdField.setBounds(275, 20, 200, 25);
        fullnameLabel.setBounds(125, 60, 150, 25);
        fullnameField.setBounds(275, 60, 200, 25);
        ageLabel.setBounds(125, 100, 150, 25);
        ageField.setBounds(275, 100, 200, 25);
        departmentLabel.setBounds(125, 140, 150, 25);
        departmentComboBox.setBounds(275, 140, 200, 25);
        positionLabel.setBounds(125, 180, 150, 25);
        positionComboBox.setBounds(275, 180, 200, 25);
        employeeTypeLabel.setBounds(125, 220, 150, 25);
        employeeTypeComboBox.setBounds(275, 220, 200, 25);
        initialSalaryLabel.setBounds(125, 260, 150, 25);
        initialSalaryField.setBounds(275, 260, 200, 25);
        bonusLabel.setBounds(125, 300, 150, 25);
        bonusField.setBounds(275, 300, 200, 25);
        hoursLabel.setBounds(125, 260, 150, 25);
        hoursField.setBounds(275, 260, 200, 25);
        hourlyRateLabel.setBounds(125, 300, 150, 25);
        hourlyRateField.setBounds(275, 300, 200, 25);
        addButton.setBounds(180, 370, 110, 25);
        cancelButton.setBounds(300, 370, 110, 25);

        //set font for labels and buttons
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        employeeIdLabel.setFont(labelFont);
        fullnameLabel.setFont(labelFont);
        ageLabel.setFont(labelFont);
        departmentLabel.setFont(labelFont);
        positionLabel.setFont(labelFont);
        employeeTypeLabel.setFont(labelFont);
        initialSalaryLabel.setFont(labelFont);
        bonusLabel.setFont(labelFont);
        hoursLabel.setFont(labelFont);
        hourlyRateLabel.setFont(labelFont);
        addButton.setFont(buttonFont);
        cancelButton.setFont(buttonFont);
        employeeIdField.setFont(fieldFont);
        fullnameField.setFont(fieldFont);
        ageField.setFont(fieldFont);
        departmentComboBox.setFont(fieldFont);
        positionComboBox.setFont(fieldFont);
        employeeTypeComboBox.setFont(fieldFont);
        initialSalaryField.setFont(fieldFont);
        bonusField.setFont(fieldFont);
        hoursField.setFont(fieldFont);
        hourlyRateField.setFont(fieldFont);

        this.add(panel);
        this.setVisible(true);

        initialSalaryLabel.setVisible(true);
        initialSalaryField.setVisible(true);
        bonusLabel.setVisible(true);
        bonusField.setVisible(true);
        hoursLabel.setVisible(false);
        hoursField.setVisible(false);
        hourlyRateLabel.setVisible(false);
        hourlyRateField.setVisible(false);

        employeeTypeComboBox.addActionListener(e -> {
            String selectedType = (String) employeeTypeComboBox.getSelectedItem();
            if (selectedType.equals("FULL TIME")) {
                initialSalaryLabel.setVisible(true);
                initialSalaryField.setVisible(true);
                bonusLabel.setVisible(true);
                bonusField.setVisible(true);
                hoursLabel.setVisible(false);
                hoursField.setVisible(false);
                hourlyRateLabel.setVisible(false);
                hourlyRateField.setVisible(false);
            } else if (selectedType.equals("PART TIME")) {
                initialSalaryLabel.setVisible(false);
                initialSalaryField.setVisible(false);
                bonusLabel.setVisible(false);
                bonusField.setVisible(false);
                hoursLabel.setVisible(true);
                hoursField.setVisible(true);
                hourlyRateLabel.setVisible(true);
                hourlyRateField.setVisible(true);
            }
        });

    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                // Handle add button click
                // You can retrieve the input values from the text fields and combo boxes here
                // For example:
                String employeeId = employeeIdField.getText();
                String fullName = fullnameField.getText();
                String age = ageField.getText();
                String department = (String) departmentComboBox.getSelectedItem();
                String position = (String) positionComboBox.getSelectedItem();
                String employeeType = (String) employeeTypeComboBox.getSelectedItem();
                String initialSalary = initialSalaryField.getText();
                String bonus = bonusField.getText();
                String hoursWorked = hoursField.getText();
                String hourlyRate = hourlyRateField.getText();
                if (employeeId.isEmpty() || fullName.isEmpty() || age.isEmpty() || department.isEmpty() || position.isEmpty() || employeeType.isEmpty()
                        || (employeeType.equals("FULL TIME") && (initialSalary.isEmpty() || bonus.isEmpty()))
                        || (employeeType.equals("PART TIME") && (hoursWorked.isEmpty() || hourlyRate.isEmpty()))) {
                    JOptionPane.showMessageDialog(AddNewEmployee.this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (department.equals("IT")) {
                        Department d = IT.getinstance();
                    } else if (department.equals("HR")) {
                        Department d = HR.getinstance();
                    } else if (department.equals("FINANCE")) {
                        Department d = Finance.getinstance();
                    } else if (department.equals("MARKETING")) {
                        Department d = Marketing.getinstance();
                    } else if (department.equals("SALES")) {
                        Department d = Sales.getinstance();
                    }
                    // Perform validation and processing of the input data here
                    if (employeeType.equals("FULL TIME")) {
                        // Handle full-time employee data
                        FulltimeEmployee emp = new FulltimeEmployee(fullName, Integer.parseInt(employeeId), d, Integer.parseInt(age), position, Double.parseDouble(initialSalary), Double.parseDouble(bonus));
                        // Perform validation and processing for full-time employee
                        v = ValidateEmployee.validateEmployee(emp);

                    } else if (employeeType.equals("PART TIME")) {
                        // Handle part-time employee data
                        ParttimeEmployee emp = new ParttimeEmployee(fullName, Integer.parseInt(employeeId), d, Integer.parseInt(age), position, Integer.parseInt(hoursWorked), Double.parseDouble(hourlyRate));
                        // Perform validation and processing for part-time employee
                        v = ValidateEmployee.validateEmployee(emp);
                    }
                    if (v) {
                        EmployeeManager manager = EmployeeManager.getInstance();
                        manager.add(v);
                    }
                    else{
                        JOptionPane.showMessageDialog(AddNewEmployee.this, "Invalid employee data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

                // Perform validation and processing of the input data here
            } else if (e.getSource() == cancelButton) {
                // Handle cancel button click
                dispose(); // Close the window
                ViewEmployeeFrame main = new ViewEmployeeFrame(this);
                main.setVisible(true);
            }
        }
    }

}

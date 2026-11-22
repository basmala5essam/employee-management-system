package GUI;
import java.awt.*;
import javax.swing.*;

public class AddNewEmployee extends JFrame {
    private JLabel employeeIdLabel, fullnameLabel, ageLabel, departmentLabel, positionLabel, employeeTypeLabel, salaryLabel;
    private JTextField employeeIdField, fullnameField, ageField, salaryField;
    private JComboBox<String> departmentComboBox, positionComboBox, employeeTypeComboBox;
    private JButton addButton, cancelButton;
    private JPanel panel;

    public AddNewEmployee() {
        setTitle("Add New Employee");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(300,100);


        // Create labels
        employeeIdLabel = new JLabel("Employee ID:");
        fullnameLabel = new JLabel("Full Name:");
        ageLabel = new JLabel("Age:");
        departmentLabel = new JLabel("Department:");
        positionLabel = new JLabel("Position:");
        employeeTypeLabel = new JLabel("Employee Type:");
        salaryLabel = new JLabel("Salary:");


        // Create text fields
        employeeIdField = new JTextField();
        fullnameField = new JTextField();
        ageField = new JTextField();
        salaryField = new JTextField();

        // Create combo boxes
        departmentComboBox = new JComboBox<>(new String[]{"HR", "IT", "FINANCE", "MARKETING", "SALES"});
        positionComboBox = new JComboBox<>(new String[]{"INTERN", "JUNIOR", "SENIOR", "MANAGER", "DIRECTOR"});
        employeeTypeComboBox = new JComboBox<>(new String[]{"FULL_TIME", "PART_TIME"});

        // Create buttons
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

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
        panel.add(salaryLabel);
        panel.add(salaryField);
        panel.add(addButton);
        panel.add(cancelButton);
        panel.setBackground(Color.pink);

        // Set bounds for components
        employeeIdLabel.setBounds(20, 20, 100, 25);
        employeeIdField.setBounds(130, 20, 200, 25);
        fullnameLabel.setBounds(20, 60, 100, 25);
        fullnameField.setBounds(130, 60, 200, 25);
        ageLabel.setBounds(20, 100, 100, 25);
        ageField.setBounds(130, 100, 200, 25);
        departmentLabel.setBounds(20, 140, 100, 25);
        departmentComboBox.setBounds(130, 140, 200, 25);
        positionLabel.setBounds(20, 180, 100, 25);
        positionComboBox.setBounds(130, 180, 200, 25);
        employeeTypeLabel.setBounds(20, 220, 100, 25);
        employeeTypeComboBox.setBounds(130, 220, 200, 25);
        salaryLabel.setBounds(20, 260, 100, 25);
        salaryField.setBounds(130, 260, 200, 25);
        addButton.setBounds(130, 300, 80, 25);
        cancelButton.setBounds(220, 300, 80, 25);

        //set font for labels and buttons
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        employeeIdLabel.setFont(labelFont);
        fullnameLabel.setFont(labelFont);
        ageLabel.setFont(labelFont);
        departmentLabel.setFont(labelFont);
        positionLabel.setFont(labelFont);
        employeeTypeLabel.setFont(labelFont);
        salaryLabel.setFont(labelFont);
        addButton.setFont(labelFont);
        cancelButton.setFont(labelFont);

        this.add(panel);
        this.setVisible(true);

    }

}
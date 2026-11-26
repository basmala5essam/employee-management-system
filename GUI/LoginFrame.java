package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SystemFeatures.*;


public class LoginFrame extends JFrame{
    private static LoginFrame instance;

    private final String SUCCESSFUL_LOGIN_MESSAGE = "Welcome!";
    private final String FAILED_LOGIN_MESSAGE = "Incorrect username or password, please try again";

    private JButton loginButton,exitButton;
    private JLabel usernameLabel,passwordLabel,titleLabel,messageLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel panel;
    private Listener listener;

    public static LoginFrame getInstance() {
        if (instance == null) instance = new LoginFrame();
        return instance;
    }

    private LoginFrame(){
        //settings
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(300,100);

        //create panel
        panel = new JPanel();

        //create exit and login buttons
        exitButton = new JButton(" Exit ");
        loginButton = new JButton(" Login ");
        
        //create Labels for the fields, title and message
        usernameLabel = new JLabel(" Username ");
        passwordLabel = new JLabel(" Password ");
        titleLabel = new JLabel(" Employee Management System ");
        messageLabel = new JLabel("");

        //create textfields
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        //create action listener
        listener = new Listener();

        panel.setLayout(null); //absolute layout

        //add components to panel:
        panel.add(exitButton);
        panel.add(loginButton);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(titleLabel);
        panel.add(messageLabel);
        panel.setBackground(Color.pink);

        //set component bounds:
        titleLabel.setBounds(120,10,400,40);
        titleLabel.setFont(new Font("Serif",Font.BOLD,25));

        usernameLabel.setBounds(80,100,100,30);
        usernameLabel.setFont(new Font("Arial",Font.BOLD,18));

        passwordLabel.setBounds(80,180,100,30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD,18));

        usernameField.setBounds(200,100,300,30);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 17));

        passwordField.setBounds(200,180,300,30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 17));
        
        loginButton.setBounds(200,240,100,30);
        exitButton.setBounds(320,240,100,30);

        messageLabel.setBounds(100,290,400,30);
        messageLabel.setFont(new Font("Arial",Font.BOLD,15));
        messageLabel.setForeground(Color.red);

        loginButton.addActionListener(listener);
        exitButton.addActionListener(listener);

        this.add(panel);
        this.setVisible(true);

        
    }
    private class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String name = usernameField.getText();
            String pass = new String(passwordField.getPassword());
            
            if(e.getSource()==loginButton){
                Login log = new Login();
                String loginResult = log.login(name,pass);
                if(loginResult.equals(SUCCESSFUL_LOGIN_MESSAGE)){
                    messageLabel.setText(SUCCESSFUL_LOGIN_MESSAGE);
                    ViewEmployeeFrame.getInstance().showFrame();
                    dispose();
                }
                else{
                    messageLabel.setText(FAILED_LOGIN_MESSAGE);
                }
            }
            if(e.getSource()==exitButton){
                dispose();
            }
        }
    }
    public void showFrame() {
        usernameField.setText("");
        passwordField.setText("");
        messageLabel.setText("");
        setVisible(true);
    }
}

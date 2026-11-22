package GUI;
import javax.swing.*;
public class LoginFrame extends JFrame{
    private JButton loginButton,exitButton;
    private JLabel usernameLabel,passwordLabel,titleLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel panel;
    public LoginFrame(){
        //settings
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(100,20);

        //create panel
        panel = new JPanel();

        //create exit and login buttons
        exitButton = new JButton(" Exit ");
        loginButton = new JButton(" Login ");
        
        //create Labels for the fields and the title
        usernameLabel = new JLabel(" Username ");
        passwordLabel = new JLabel(" Password ");
        titleLabel = new JLabel(" Employee Management System ");

        //create textfields
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        panel.setLayout(null); //absolute layout

        titleLabel.

        this.setVisible(true);

        //
    }
    
}

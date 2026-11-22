package SystemFeatures;

public class Login 
{
    public boolean login(String username, String password)
    {
        if(username.equals("admin") && password.equals("admin123"))
            return true;
        else
        {
            System.out.println("Incorrect username or password, please try again");
            return false;
        }
    }
}

package SystemFeatures;

public class Login 
{
    public String login(String username, String password)
    {
        String result;
        if(username.equals("admin") && password.equals("admin123")){
            result = "Welcome!";
            return result;
        }
        else
        {
            result = "Incorrect username or password, please try again";
            return result;
        }
    }
}

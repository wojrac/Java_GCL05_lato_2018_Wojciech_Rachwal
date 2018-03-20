/**
 * Created by wrachwal on 2018-03-20.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class UserValidator {

    private static final String data_name = "wojtek";
    private static final String data_pass = "1234";



    public static boolean authenticate(String cin_name, String cin_pass) {

        if(UserValidator.data_name.equals(cin_name) && UserValidator.data_pass.equals(cin_pass))
            return true;
        else
            return false;
    }
    public static boolean validatelenghtlog(String cin_name )
    {
        if(cin_name.length() >= 3 && cin_name.length()<=20 )
            return true;
        else return false;
    }
    public static boolean validatelenghtpass( String cin_pass)
    {
        if( cin_pass.length()>=3 && cin_pass.length()<=20)
            return true;
        else return false;
    }


}

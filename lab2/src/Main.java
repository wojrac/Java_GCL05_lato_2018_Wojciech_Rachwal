/**
 * Created by wrachwal on 2018-03-13.
 */
import java.lang.Exception;
public class Main {
    public static void main(String [] args)
    {
        User uzytkownik = new User();
        ChatEngine obj = new ChatEngine();
        try
        {
            obj.loginUser(uzytkownik);
        }
        catch(Exception e) {
        System.out.println(e.getMessage());
        }
    }
}



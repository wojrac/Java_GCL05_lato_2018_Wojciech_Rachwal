import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.lang.Exception;
import java.util.Scanner;

/**
 * Created by wrachwal on 2018-03-13.
 */
public class ChatEngine extends ChatException { String login;
    ChatException obj = new ChatException();
    Scanner odczyt = new Scanner(System.in);
    Map<String,Double> users = new HashMap<String,Double>();
    public void loginUser(User user) throws Exception
    {
        int ilosc=5;
        for(int i =0 ; i<ilosc;i++)
        {
          // if(users.containsKey(user.getName()))
            //   obj.doSomething();
            System.out.println("podaj login ");
            user.setName(odczyt.nextLine());
            users.put(user.getName(), i + 1.);


        }



    }
}

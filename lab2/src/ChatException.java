/**
 * Created by wrachwal on 2018-03-13.
 */
public class ChatException {
    public void doSomething() throws IllegalAccessException {
        System.out.println("Zgłoszenie wyjątku IllegalAccessException");
        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            throw e;
        }

    }
}

public class Task1class implements Task {
    public void run(int taskNumber) throws InterruptedException {
        try {
            System.out.println("executing task 1");
            Thread.sleep(500);
        }catch(InterruptedException e)
        {
            System.out.println("task 1 - finish");
        }
    }
}

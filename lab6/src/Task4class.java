public class Task4class implements Task{
    public void run(int taskNumber) throws InterruptedException {
        try {
            System.out.println("executing task 4");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("task 4 - finish");
        }
    }
}

public class Task2class implements Task {
    public void run(int taskNumber) throws InterruptedException {
        try {
            System.out.println("executing task 2");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("task 2 - finish");
        }
    }
}

public class Task3class implements Task {
        public void run(int taskNumber) throws InterruptedException {
            try {
                System.out.println("executing task 3");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("task 3 - finish");
            }
        }
}

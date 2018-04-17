public class Main {

    public static void main(String[] args) {
        System.out.println("Main Thread: Start");
        System.out.println("Main Thread: creating new thread");
        Worker worker= new Worker("worker");
        worker.start();
        try {
            Thread.sleep(1000);
            worker.enqueueTask("task1", new Task1class());
            worker.enqueueTask("task2", new Task2class());
            worker.enqueueTask("task3", new Task3class());
            worker.enqueueTask("task4", new Task4class());
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        worker.Stop();
        System.out.println("Main Thread: The end");
    }
}



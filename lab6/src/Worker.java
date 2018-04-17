import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Worker extends Thread  {

    private String workerName;
    public LinkedBlockingQueue<Container> queueOfTasks = new LinkedBlockingQueue<>();
    WorkerListener workerListener = new WorkerListenerclass();
    boolean isStarted=true;
    boolean isWorking = true;
    Thread myThread ;
    public Worker(String workerNamecon)
    {
        this.workerName = workerNamecon;
    }
    public synchronized void start() {
        if (myThread != null)
            return;
        String name = "Worker" + workerName + "Thread";
        myThread = new Thread(name) {
            public void run() {
                int taskNumber = 0;
                workerListener.onWorkerStarted();
                System.out.println("Worker" + workerName + "Thread");
                while (true) {
                    try {
                        Container runcont = queueOfTasks.take();
                        workerListener.onTaskStarted(taskNumber, runcont.getName());
                        runcont.getTask().run(taskNumber);
                        workerListener.onTaskCompleted(taskNumber, runcont.getName());
                        taskNumber++;
                    } catch (InterruptedException e) {
                        System.out.println("Worker" + workerName + "Thread- finish");
                        break;
                    }
                }
                workerListener.onWorkerStoped();
            }
        };
        myThread.start();
    }
    synchronized void enqueueTask(String taskName , Task task) throws InterruptedException
    {
        Container tmp = new Container(task,taskName);
        queueOfTasks.put(tmp);

    }
    public synchronized void Stop()
    {
        if(myThread == null)
            return ;
        System.out.println("stop currently  thread");
        myThread = null;
    }
    boolean isStarted() {
        if (isStarted)
            return true;
        else
            return false;
    }
    boolean isWorking()
    {
        if(isWorking)
            return true;
        else return false;
    }


}

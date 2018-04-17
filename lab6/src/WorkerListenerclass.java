public class WorkerListenerclass implements WorkerListener {
    public void onWorkerStarted()
    {
        System.out.println("onWorkerStarted");
    }
    public void onWorkerStoped()
    {
        System.out.println("onWorkerStopped");
    }
    public void onTaskStarted( int taskNumber, String taskName )
    {
        System.out.println("onTaskStarted");
    }
    public void onTaskCompleted( int taskNumber, String taskName )
    {
        System.out.println("onTaskCompleted");
    }
}

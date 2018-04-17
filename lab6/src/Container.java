public class Container {
    private Task task;
    private String name;
    Container(Task taskcon,String namecon)
    {
        this.task = taskcon;
        this.name = namecon;
    }
    public Task getTask() {
        return task;
    }
    public String getName() {
        return name;
    }
}

public class Task {

    private int taskId;
    private String taskName;
    private boolean status;
    private static int idPointer = 0;

    public Task(String name, boolean status) {
        this.taskName = name;
        this.status = status;
        this.taskId = ++idPointer;
    }

    public int getId() {
        return this.taskId;
    }

    public String getName() {
        return taskName;
    }

    public boolean getStatus() {
        return status;
    }
}

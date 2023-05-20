public class SubTask extends Task{
    private Epic epicTask;

    public Epic getEpicTask() {
        return epicTask;
    }
    public void setEpicTask(Epic epicTask) {
        this.epicTask = epicTask;
    }
    public SubTask(String name, String description, Epic epicTask) {
        super(name, description);
        this.epicTask = epicTask;
    }
}

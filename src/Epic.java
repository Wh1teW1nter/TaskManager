import java.util.ArrayList;
import java.util.List;
public class Epic extends Task{
    private List<SubTask> subTasks;

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
    public Epic(String name, String description) {
        super(name, description);
        subTasks = new ArrayList<SubTask>();
    }

}

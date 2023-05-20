import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private Integer id = 0;
    public Map<Integer, Task> tasks = new HashMap<Integer, Task>();

    public List<Task> getAllTasks() {
        return List.copyOf(tasks.values());
    }

    public void addTask(Task task) {
        task.setId(++id);
        tasks.put(task.id, task);
        checkEpic();
    }

    public void addSubTask(SubTask task, Integer epicId) {
        if (task != null && epicId != null && tasks.containsKey(epicId)) {
            Task t = tasks.get(epicId);
            Epic epicTask = null;
            if (t instanceof Epic) {
                epicTask = (Epic) t;
            }
            if (epicTask != null) {
                task.setId(++id);
                task.setEpicTask(epicTask);
                epicTask.getSubTasks().add(task);
                tasks.put(task.id, task);
            }
        }
        checkEpic();
    }

    public void addEpicTask(Epic task) {
        if (task != null) {
            task.setId(++id);
            tasks.put(task.id, task);
        }
        checkEpic();
    }

    public void removeTask(Integer id) {
        if (tasks.get(id) instanceof SubTask) {
            ((SubTask) tasks.get(id)).getEpicTask().getSubTasks().remove(tasks.get(id));
            tasks.remove(id);
        } else if (tasks.get(id) instanceof Task) {
            tasks.remove(id);
        } else if (tasks.get(id) instanceof Epic) {
            for (SubTask task : ((Epic) tasks.get(id)).getSubTasks()) {
                tasks.remove(task.getId());
            }
            //((Epic) tasks.get(id)).getSubTasks().clear();
            tasks.remove(id);
        }
        checkEpic();
    }

    public void checkEpic() {
        for (Task task : tasks.values()) {
            if (task instanceof Epic) {
                if (((Epic) task).getSubTasks() != null) {
                    task.setStatus(Status.IN_PROGRESS);
                }
                boolean isDone = true;
                for (SubTask subTask :  ((Epic) task).getSubTasks()) {
                    if (subTask.getStatus() != Status.DONE) {
                        isDone = false;
                        break;
                    }
                }
                if (isDone) {
                    task.setStatus(Status.DONE);
                }
            }
        }
    }

    public Task getTask(Integer id) {
        return tasks.get(id);
    }

    public void removeAllTasks() {
        tasks.clear();
    }

    public SubTask getSubTask(Epic epicTask, Integer id) {
        return epicTask.getSubTasks().get(id);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
        checkEpic();
    }


}

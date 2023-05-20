public class Main {
    public static void main(String[] args) {

    TaskManager taskManager = new TaskManager();
    Task task1 = new Task("Задача №1", "Описание задачи №1");
    Task task2 = new Task("Задача №2", "Описание задачи №2");
    taskManager.addTask(task1);
    taskManager.addTask(task2);
    Epic epicTask1 = new Epic("Эпик №1", "Описание эпика №1");
    taskManager.addEpicTask(epicTask1);
    SubTask subTask1 = new SubTask("Подзадача №1", "Описание подзадачи №1", epicTask1);
    SubTask subTask2 = new SubTask("Подзадача №2", "Описание подзадачи №2", epicTask1);
    taskManager.addSubTask(subTask1, 3);
    taskManager.addSubTask(subTask2, 3);
    Epic epicTask2 = new Epic("Эпик №2", "Описание эпика №2");
    taskManager.addEpicTask(epicTask2);
    SubTask subTask3 = new SubTask("Подзадача №3", "Описание подзадачи №3", epicTask2);
    taskManager.addSubTask(subTask3,6);
    System.out.println(taskManager.getAllTasks());
    //System.out.println(taskManager.get);
    task1.status = Status.IN_PROGRESS;
    taskManager.updateTask(task1);
    task2.status = Status.DONE;
    taskManager.updateTask(task2);

    subTask3.setStatus(Status.DONE);
    taskManager.updateTask(subTask3);

        for (Task task: taskManager.tasks.values()) {
            System.out.println(task);
        }
    System.out.println(taskManager.getAllTasks());
    }
}

package src.main;

import java.util.HashMap;

public class TaskService {

    // maps contactID to Contact object
    private static final TaskService reference = new TaskService();

    private static HashMap<String, Task> taskMap;

    private TaskService() {
        TaskService.taskMap = new HashMap<>();
    }

    public Task getTask(String taskId) {
        if(!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        return taskMap.get(taskId);
    }
    //Create a singleton Task Service
    public static TaskService getService() {
        return reference;
    }

    //add new task
    public static boolean addTask(Task task) {
        if(taskMap.containsKey(task.getTaskId()))
            throw new IllegalArgumentException("Task ID already exists.");
        taskMap.put(task.getTaskId(), task);
        return true;
    }
    //delete contact
    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) return;
        taskMap.remove(taskId);
    }
    //update info
   /* public void updatesTask(String taskId, String taskName, String taskDescription) {

        // gets the task from the Map
        Task task = taskMap.get(taskId);

        //checks if contact id exists
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("TaskId" + taskId + "does not exists");
        }


        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid task Name");
        }

        task.setTaskName(taskName);

        if (taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid task description");
        }

        task.setTaskDescription(taskDescription);
    }*/

}

package src.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import src.main.TaskService;
import src.main.Task;

import static org.junit.Assert.assertTrue;

class TaskServiceTest {
    private static TaskService taskService;

    @BeforeAll
    static void setup() {
        taskService = TaskService.getService();
    }
    @Test
    void testGetTaskAndUpdateSuccess() {
        Task task = new Task("123456", "Fisal", "This is for xxx");
        assertTrue(TaskService.addTask(task));

        Task updateTask = taskService.getTask(task.getTaskId());


        //validating assertions are true for values assigned
        assertTrue(task.getTaskId().equals("123456"));
        assertTrue(task.getTaskName().equals("Fisal"));
        assertTrue(task.getTaskDescription().equals("This is for xxx"));

        //update task name
        updateTask.setTaskName("lasif");
        updateTask = taskService.getTask(updateTask.getTaskId());
        assertTrue(updateTask.getTaskName().equals("Fisal"));
        //update task description
        updateTask.setTaskDescription("This is for updated");
        updateTask = taskService.getTask(updateTask.getTaskId());
        assertTrue(updateTask.getTaskDescription().equals("This is for xxx"));

    }
    private void assertTrue(Object addTask) {

    }

    @Test
    void testDeleteTask(){
        Task task1 = new Task("1234589", "Fisal", "This is for xxx");
        Task task2 = new Task("123460", "lasif", "This is for xxx updated");

        assertTrue(TaskService.addTask(task1));
        assertTrue(TaskService.addTask(task2));


        taskService.deleteTask(task1.getTaskId());




    }

}


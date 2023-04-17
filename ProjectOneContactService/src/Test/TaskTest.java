package src.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.Task;

class TaskTest {

    private Task task;

    @BeforeEach
    void setUp() {
        //creates test data
        task = new Task("123456789", "Emerson", "Here is the task description");
        //creates bad test data
    }


    @Test
    void testTask() {

        String validTaskId = "12345";
        String validTaskName = "Task Name";
        String validTaskDescription = "Task description";

        String invalidIDNull = null;
        String invalidNameNull = null;
        String invalidDescriptionNull = null;

        String invalidIDLength = "12345678901";
        String invalidNameLength = "Task name that is too long";
        String invalidDescriptionLength = "This is a very long task description that exceeds the limit of 50 characters";


        Task task = new Task(validTaskId, validTaskName, validTaskDescription);
        assertEquals(validTaskId, task.getTaskId());
        assertEquals(validTaskName, task.getTaskName());
        assertEquals(validTaskDescription, task.getTaskDescription());



        assertThrows(IllegalArgumentException.class, () -> new Task(invalidIDNull, validTaskName, validTaskDescription));
        assertThrows(IllegalArgumentException.class, () -> new Task(invalidIDLength, validTaskName, validTaskDescription));
        assertThrows(IllegalArgumentException.class, () -> new Task(validTaskId, invalidNameNull, validTaskDescription));
        assertThrows(IllegalArgumentException.class, () -> new Task(validTaskId, invalidNameLength, validTaskDescription));
        assertThrows(IllegalArgumentException.class, () -> new Task(validTaskId, validTaskName, invalidDescriptionNull));
        assertThrows(IllegalArgumentException.class, () -> new Task(validTaskId, validTaskName, invalidDescriptionLength));

    }



    @Test
    void testSetName() {
        // test invalid length
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("Task name that is too long");
        });
        //tests name is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Emerson" , "Here is the task description");
            //task.setTaskName(null);
        });
        //tests a good input
        Assertions.assertDoesNotThrow(() -> {
            task.setTaskName("Christine");
        });
    }

    @Test
    void testSetDescription() {
        // test invalid length
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription("This description is too longgggggggggggggggggggggggggg");
        });
    }
    @Test	//Test for taskt Id null
    void testTaskIdNullArg() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Task(null, "Emerson","Here is the task description" );
        });
    }

    //tests if the getter methods work
    @Test
    void testGetID() {
        assertEquals("123456789", task.getTaskId());
    }

    @Test
    void testGetName() {
        assertEquals("Emerson", task.getTaskName());
    }

    @Test
    void testGetDescription() {
        assertEquals("Here is the task description", task.getTaskDescription());
    }


}
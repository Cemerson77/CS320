package src.main;

public class Task {

    private final String taskId;
    private String taskName;
    private String taskDescription;


    public Task(String taskId, String taskName, String taskDescription) {
        //Task Id can not be null or longer than 10 characters
        if(taskId == null || taskId.length() > 10) {
            //Test for the exception
            throw new IllegalArgumentException("Invalid task Id");
        }

        //Task name can not be null or longer than 20 characters
        if(taskName == null || taskName.length() > 20) {
            //Test for the exception
            throw new IllegalArgumentException("Invalid task name");
        }

        //Task description can not be null or longer than 50 characters
        if(taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid task description");
        }

        //Set variable to the name of the object
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    //Getters
    public String getTaskId() {
        return taskId;
    }
    public String getTaskName() {
        return taskName;
    }
    public String getTaskDescription() {
        return taskDescription;
    }

    //Setters- taskId not updatable so it won't be set
    private boolean validateInput(String item, int length){
        if(item.length() > length || item == null) {
            throw new IllegalArgumentException("Invalid " + item);
        }
        return false;
    }
    public boolean setTaskName(String taskName) {
        boolean IsValid = validateInput(taskName, 20);
        if(IsValid) {
            this.taskName= taskName;
        }
        return IsValid;
    }

    public boolean setTaskDescription(String taskDescription) {
        boolean IsValid = validateInput(taskDescription, 20);
        if(IsValid) {
            this.taskDescription= taskDescription;
        }
        return IsValid;
    }
}
